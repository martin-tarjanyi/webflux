package com.martin.webflux;

import com.codahale.metrics.annotation.Metered;
import com.martin.webflux.model.Video;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class WebController
{
    private final AtomicInteger atomicInteger;

    public WebController()
    {
        atomicInteger = new AtomicInteger(1);
    }

    @GetMapping("/just")
    public Mono<String> hello()
    {
        return Mono.just("Hello World");
    }

    @GetMapping("/just/now")
    public Mono<String> hello2(@RequestHeader("key") String vlaue)
    {
        return Mono.just("Hello Wold, now");
    }

    @PostMapping("/just")
    public Mono<String> postHello(@RequestBody String vlaue)
    {
        return Mono.just(vlaue);
    }

    @GetMapping("/slow")
    public Mono<String> slow()
    {
//        return Mono.<String>create(stringMonoSink -> threadPoolExecutor.schedule(() ->
//                stringMonoSink.success(atomicInteger.getAndIncrement() + ": Slow response... on remote server thread: "
//                        + Thread.currentThread().getName() + " " + LocalDateTime.now()), 3, TimeUnit.SECONDS))
//                .doOnSuccess(System.out::println);

        return Mono.delay(Duration.ofMillis(3000))
                   .then(Mono.just(atomicInteger.getAndIncrement() + ": Slow response... on remote server thread: "
                           + Thread.currentThread().getName() + " " + LocalDateTime.now()));

//        return Mono.create(monosink -> vertx.setTimer(
//                3000L,
//                ms -> monosink.success("Slow response... on remote server thread: " + Thread.currentThread().getName())));
    }

    @GetMapping("/netflix")
    @Metered
    public Mono<Video> netflix(@RequestParam String title)
    {
        return WebClient.create()
                        .get()
                        .uri("http://netflixroulette.net/api/api.php?title=" + title)
                        .exchange()
                        .flatMap(clientResponse -> clientResponse.bodyToMono(Video.class))
                        .doOnSuccess(video -> System.out.println(Thread.currentThread().getName()));
    }
}

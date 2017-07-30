package com.martin.webflux;

import com.codahale.metrics.annotation.Metered;
import com.martin.webflux.model.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebController
{
    @GetMapping("/just")
    public Mono<String> hello()
    {
        return Mono.just("Hello World");
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

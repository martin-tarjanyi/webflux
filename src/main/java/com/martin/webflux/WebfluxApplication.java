package com.martin.webflux;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMetrics
public class WebfluxApplication extends MetricsConfigurerAdapter
{
	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}
}

package com.comrade.controller;

import com.comrade.model.Greeting;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Controller
public class GreetingController {
    @QueryMapping
    public Greeting welcomeGreeting(){
        return new Greeting("Hi!, Welcome ");
    }

    @SubscriptionMapping
    public Flux<Greeting> welcomeGreetings(){
        return Flux.fromStream(Stream.generate(() -> new Greeting("Welcome"))).delayElements(Duration.ofSeconds(1)).take(10);
    }
}

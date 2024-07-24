package com.comrade.service;

import com.comrade.model.Comrade;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.List;

@Component
public class ComradeService {


    public List<Comrade> comrades(){
        return List.of(new Comrade(508,"Shiva"),new Comrade(408,"Dasari"));
    }

    public Flux<Comrade> reactiveComrades(){
        return Flux.fromIterable(List.of(new Comrade(508,"Shiva"),new Comrade(408,"Dasari")));
    }



}

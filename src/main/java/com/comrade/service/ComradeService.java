package com.comrade.service;

import com.comrade.model.Comrade;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ComradeService {
    private final Map<Integer,Comrade> comradeMap = new ConcurrentHashMap<>();
    private final AtomicInteger atomicInteger = new AtomicInteger();

    public List<Comrade> comrades(){
        return List.of(new Comrade(508,"Shiva"),new Comrade(408,"Dasari"));
    }

    public Flux<Comrade> reactiveComrades(){
        return Flux.fromIterable(List.of(new Comrade(508,"Shiva"),new Comrade(408,"Dasari")));
    }

    public Comrade getComradeById(Integer id){
        return comradeMap.get(id);
    }

    public Comrade addComrade(String name){
        var id = atomicInteger.incrementAndGet();
        var comrade = new Comrade(atomicInteger.incrementAndGet(),name);
        this.comradeMap.put(id,comrade);
        return comrade;
    }
}

package com.comrade.controller;

import com.comrade.model.Comrade;
import com.comrade.model.Dear;
import com.comrade.service.ComradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BatchRequestController {

    @Autowired
    private ComradeService comradeService;

    @QueryMapping
    public Comrade comradeById(@Argument Integer id){
        return new Comrade(id,"Shiva Dasari");
    }

    @QueryMapping
    public List<Comrade> comrades(){
        return comradeService.comrades();
    }
    @QueryMapping
    public Flux<Comrade> reactiveComrades(){
        return comradeService.reactiveComrades();
    }

    @BatchMapping
    public Map<Comrade, Dear> dear(List<Comrade> comrades){
        System.out.println("New call made");
       return comrades.stream()
                      .collect(Collectors.toMap(comrade -> comrade, comrade->new Dear(comrade.id(),comrade.id(), "Shiva "+comrade.id())));
    }

    /*@SchemaMapping(typeName = "Comrade")
    public Dear dear(Comrade comrade){
        System.out.println("New call made");
        return new Dear(comrade.id(),comrade.id(),"Good to be back");
    }*/
}

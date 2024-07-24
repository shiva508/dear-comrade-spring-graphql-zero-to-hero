package com.comrade.controller;

import com.comrade.model.Comrade;
import com.comrade.model.Dear;
import com.comrade.service.ComradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class MutationController {

    @Autowired
    private ComradeService comradeService;

    @QueryMapping
    public Comrade comradeById(@Argument Integer id){
        return comradeService.getComradeById(id);
    }

    @QueryMapping
    public List<Comrade> comrades(){
        return comradeService.comrades();
    }
    @QueryMapping
    public Flux<Comrade> reactiveComrades(){
        return comradeService.reactiveComrades();
    }

    @SchemaMapping(typeName = "Comrade")
    public Dear dear(Comrade comrade){
        return new Dear(comrade.id(),comrade.id(),"Good to be back");
    }

    @MutationMapping
    //@SchemaMapping(typeName = "Mutataion", field = "addComrade")
    public Comrade addComrade(@Argument String name){
        return comradeService.addComrade(name);
    }
}

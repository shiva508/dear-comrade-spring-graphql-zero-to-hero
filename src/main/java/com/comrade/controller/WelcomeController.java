package com.comrade.controller;

import com.comrade.model.Comrade;
import com.comrade.model.Dear;
import com.comrade.service.ComradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private ComradeService comradeService;
    //@SchemaMapping(typeName = "Query", value = "welcome")
    @QueryMapping
    public String welcome(){
        return "Welcome to new world";
    }

    @QueryMapping
    public String welcomeUser(@Argument String user){
        return "Welcome to new world ,"+user;
    }

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

    @SchemaMapping(typeName = "Comrade")
    public Dear dear(Comrade comrade){
        return new Dear(comrade.id(),comrade.id(),"Good to be back");
    }
}

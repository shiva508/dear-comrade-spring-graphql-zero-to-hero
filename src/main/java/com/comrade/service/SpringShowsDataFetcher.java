package com.comrade.service;

import com.comrade.model.Show;
import com.comrade.utill.DgsUtil;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SpringShowsDataFetcher {

    @QueryMapping
    public List<Show> springShows(@Argument Integer releaseYear){
        if (releaseYear == null){
            return DgsUtil.shows;
        }
        return DgsUtil.shows.stream().filter(show -> show.releaseYear()>=releaseYear).collect(Collectors.toList());
    }

    @SchemaMapping(typeName = "Query" , value = "springAllShows")
    public List<Show> springAllShows(){

        return DgsUtil.shows;
    }
}

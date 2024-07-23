package com.comrade.service;

import com.comrade.model.Show;
import com.comrade.utill.DgsUtil;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class DgsShowsDataFetcher {


    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {
            return DgsUtil.shows;
        }
        return DgsUtil.shows.stream().filter(s -> s.title().contains(titleFilter)).collect(Collectors.toList());
    }

    @DgsQuery
    public List<Show> dgsShows(@InputArgument Integer releaseYear){
        if (releaseYear == null){
            return DgsUtil.shows;
        }
       return DgsUtil.shows.stream().filter(show -> show.releaseYear()>=releaseYear).collect(Collectors.toList());
    }
}

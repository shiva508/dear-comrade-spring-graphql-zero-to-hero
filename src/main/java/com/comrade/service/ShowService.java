package com.comrade.service;

import com.comrade.client.DgsShowsGraphQLQuery;
import com.comrade.client.DgsShowsProjectionRoot;
import com.comrade.types.Show;
import com.netflix.graphql.dgs.client.MonoGraphQLClient;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class ShowService {
    private final WebClient dgsWebClient;

    public ShowService(WebClient dgsWebClient) {
        this.dgsWebClient = dgsWebClient;
    }

    public void getShows(){
        //Build query
        DgsShowsGraphQLQuery dgsShowsGraphQLQuery = new DgsShowsGraphQLQuery.Builder()
                                                                            .releaseYear(2019)
                                                                            .build();
        // defines what fields we need to get data
        DgsShowsProjectionRoot dgsShowsProjectionRoot = new DgsShowsProjectionRoot().title();

        // Creating request
        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(dgsShowsGraphQLQuery, dgsShowsProjectionRoot);

        //Create client using  webClient
        var response = MonoGraphQLClient.createWithWebClient(dgsWebClient)
                                         .reactiveExecuteQuery(graphQLQueryRequest.serialize())
                                         .block();
        assert response != null;
        List<Show> shows = response.extractValueAsObject("dgsShows", List.class);
        System.out.println(shows);
        System.out.println(response.getJson());
    }
}

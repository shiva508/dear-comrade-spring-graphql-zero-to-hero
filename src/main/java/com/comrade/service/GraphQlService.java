package com.comrade.service;

import com.comrade.model.Comrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

@Component
public class GraphQlService {

    @Value("${client.base-url}")
    private String baseUrl;
    @Autowired
    private HttpGraphQlClient httpGraphQlClient;

    public void comradeById(Integer id){
        var httpRequestDocument = """
                   query dynamicComradeById($id: ID!){
                     comradeById(id: $id){
                        id,
                        name
                  }
                }
                """;
        httpGraphQlClient.document(httpRequestDocument)
                         .variable("id",id)
                         .retrieve("comradeById")
                         .toEntity(Comrade.class)
                         .subscribe(System.out::println);
    }

}

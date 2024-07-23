package com.comrade.config;

import com.comrade.model.Currency;
import com.comrade.service.CustomerService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.EnumValuesProvider;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.function.UnaryOperator;

@Configuration
public class GraphQLCustomConfig {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(CustomerService customerService){
        return builder -> {
            builder.type("Customer", writing -> writing
                    .dataFetcher("profile", environment -> customerService.getProfileById(environment.getSource())));
            builder.type("Query", wiring -> wiring
                    .dataFetcher("findByCustomerId",environment -> customerService.findByCustomerId(Integer.parseInt(environment.getArgument("id"))))
                    .dataFetcher("allCustomers", environment -> customerService.customersList())
            );
        };
    }

}

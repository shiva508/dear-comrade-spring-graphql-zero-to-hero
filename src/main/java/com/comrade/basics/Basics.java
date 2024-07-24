package com.comrade.basics;

import com.comrade.basics.DataCenter;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

public class Basics {
    public static void main(String[] args) {
        String schema = "type Query { welcomeNew(name:String) : String }";
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);
        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query",
                        builder -> builder.dataFetcher("welcomeNew",
                                environment -> DataCenter.welcomeMessage(environment.getArgument("name"))))
                .build();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = graphQL.execute("{welcomeNew(name: \"SHIVA\") }");
        System.out.println(executionResult);
    }

    public static void withoutArgument(){
        String schema = "type Query { welcome: String }";// Q

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);
        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query",
                        builder -> builder.dataFetcher("welcome",
                                new StaticDataFetcher("Welcome to GRAPHQL World"))).build();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = graphQL.execute("{welcome}");
        System.out.println(executionResult);
    }
}
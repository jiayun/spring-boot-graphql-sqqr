package com.igu.developer.demo.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Custom {
    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id" )
    private Long id;
    @GraphQLQuery(name = "name")
    private @NonNull
    String name;
    @GraphQLQuery(name = "invoice")
    private @NonNull
    int invoice;
    @GraphQLQuery(name = "bossName")
    private @NonNull
    String bossName;
    /*@GraphQLQuery(name = "hr")
    private @NonNull
    String hr;*/
    @GraphQLQuery(name = "region")
    private @NonNull
    String region;
    @GraphQLQuery(name = "address")
    private @NonNull
    int address;
    @GraphQLQuery(name = "addressDesc")
    private @NonNull
    int addressDesc;
    @GraphQLQuery(name = "empCount")
    private @NonNull
    int empCount;
    @GraphQLQuery(name = "capital")
    private @NonNull
    int capital;
    /*@GraphQLQuery(name = "industry")
    private @NonNull
    int industry;*/
    @GraphQLQuery(name = "flag")
    private @NonNull
    int flag;


}

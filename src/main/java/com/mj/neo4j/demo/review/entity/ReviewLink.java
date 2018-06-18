package com.mj.neo4j.demo.review.entity;


import com.mj.neo4j.demo.account.entity.AccountNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@Data
@ToString(exclude = {"account","service"})
@NoArgsConstructor

@RelationshipEntity(type=ReviewLink.RELATIONSHIP)
public class ReviewLink {

    public static final String RELATIONSHIP = "REVIEWED";

    @Id
    @GeneratedValue
    private Long id;


    private Integer rating;

    private String content;

    @StartNode
    private AccountNode account;

    @EndNode
    private ServiceNode service;

}

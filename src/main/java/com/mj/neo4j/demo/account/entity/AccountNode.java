package com.mj.neo4j.demo.account.entity;

import com.mj.neo4j.demo.review.entity.ReviewLink;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor

@NodeEntity

public class AccountNode {

    @Id
    @GeneratedValue
    private Long id;

    private Long accountId;

    private String email;

    private String firstName;

    private String lastName;

    @Relationship(type = ReviewLink.RELATIONSHIP)
    private List<ReviewLink> reviews = new ArrayList<>();

}

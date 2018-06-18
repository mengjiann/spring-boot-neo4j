package com.mj.neo4j.demo.review.entity;

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
public class ServiceGroupNode {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = ServiceGroupLink.RELATIONSHIP,direction = Relationship.INCOMING)
    private List<ServiceGroupLink> links = new ArrayList<>();

}

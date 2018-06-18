package com.mj.neo4j.demo.review.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@Data
@ToString
@NoArgsConstructor

@RelationshipEntity(type=ServiceGroupLink.RELATIONSHIP)
public class ServiceGroupLink {

    public static final String RELATIONSHIP = "BELONGED";

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private ServiceNode serviceNode;

    @EndNode
    private ServiceGroupNode serviceGroupNode;

}

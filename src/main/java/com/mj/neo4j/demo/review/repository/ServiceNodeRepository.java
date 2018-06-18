package com.mj.neo4j.demo.review.repository;

import com.mj.neo4j.demo.review.entity.ServiceNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ServiceNodeRepository extends Neo4jRepository<ServiceNode,Long> {
    ServiceNode findByName(String name);
}
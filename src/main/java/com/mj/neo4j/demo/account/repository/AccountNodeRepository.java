package com.mj.neo4j.demo.account.repository;

import com.mj.neo4j.demo.account.entity.AccountNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountNodeRepository  extends Neo4jRepository<AccountNode,Long> {

    AccountNode findByEmail(String email);

    @Query("MATCH (account:AccountNode{email:{accountEmail}})-[:FRIENDED*2]-(friends) WHERE NOT (account)-[:FRIENDED]-(friends) RETURN DISTINCT friends")
    List<AccountNode> listSecondDegreeFriendForAccount(@Param("accountEmail") String email);

}

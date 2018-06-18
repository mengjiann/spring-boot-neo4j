package com.mj.neo4j.demo;

import com.mj.neo4j.demo.account.entity.AccountNode;
import com.mj.neo4j.demo.account.repository.AccountNodeRepository;
import com.mj.neo4j.demo.review.entity.ServiceNode;
import com.mj.neo4j.demo.review.repository.ServiceNodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableNeo4jRepositories("com.mj.neo4j")
public class DemoNeo4jApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoNeo4jApplication.class, args);
	}

	@Autowired
	private AccountNodeRepository accountNodeRepository;

	@Autowired
	private ServiceNodeRepository serviceNodeRepository;


	@Override
	public void run(String... args) throws Exception {

		AccountNode accountNode = accountNodeRepository.findByEmail("lennon@gmail.com");

		log.info("Found account node: {}", accountNode);

		List<AccountNode> accountNodeList = accountNodeRepository
				.listSecondDegreeFriendForAccount("lennon@gmail.com");

		log.info("2nd degree friends recommendation for {}: {}",accountNode.getFirstName(),accountNodeList.toString());


		ServiceNode serviceNode = serviceNodeRepository.findByName("BCD Service");

		log.info("Reviews for BCD Service:");
		serviceNode.getReviewLinks().forEach(reviewLink -> {
			log.info("Review content: {} with rating: {} by account: {}",reviewLink.getContent(), reviewLink.getRating(),reviewLink.getAccount().getEmail());
		});



	}
}

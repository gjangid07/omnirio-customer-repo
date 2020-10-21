package com.omnirio.Customer;

import java.sql.SQLException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class CustomerApplication {
	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	@Bean
//	public JdbcTemplate getJdbcTemplate() {
//		return new JdbcTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}
	
//	@PostConstruct
//	private void initDb() {
//	    String sqlStatements[] = {
//	      "drop table employees if exists",
//	      "create table employees(id serial,first_name varchar(255),last_name varchar(255))",
//	      "insert into employees(first_name, last_name) values('Eugen','Paraschiv')",
//	      "insert into employees(first_name, last_name) values('Scott','Tiger')"
//	    };
//	 
//	    JdbcTemplate jdbcTemplate= new JdbcTemplate();
//	    Arrays.asList(sqlStatements).forEach(sql -> {
//	        jdbcTemplate.execute(sql);
//	    });
//	 
//	    // Query test data and print results
//	}

}

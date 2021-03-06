package com.project.rest.ws.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories(basePackages = "com.project")
@SpringBootApplication
@EnableDiscoveryClient
public class App1Application extends AbstractCassandraConfiguration{

    public static void main(String[] args) {
        SpringApplication.run(App1Application.class, args);
    }
    
    @Override
    protected String getKeyspaceName() {
        return "testKeySpace";
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = 
        new CassandraClusterFactoryBean();
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9042);
        return cluster;
}

    @Bean
    public CassandraMappingContext cassandraMapping() 
        throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}

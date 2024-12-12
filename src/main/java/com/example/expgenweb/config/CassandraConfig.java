package com.example.expgenweb.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
public class CassandraConfig {

    @Value("${spring.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.datacenter}")
    private String datacenter;

    @Value("${spring.cassandra.keyspace}")
    private String keyspace;

    @Value("${spring.cassandra.username}")
    private String username;

    @Value("${spring.cassandra.password}")
    private String password;

    @Bean
    public CqlSession cqlSession() {
        try {
            return CqlSession.builder()
                    .addContactPoint(new InetSocketAddress(contactPoints, port))
                    .withLocalDatacenter(datacenter)
                    .withKeyspace(keyspace)
                    .withAuthCredentials(username, password)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create CqlSession", e);
        }
    }
}

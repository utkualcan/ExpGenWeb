package com.example.expgenweb.config;

import lombok.Getter;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HDFSConfiguration {
    @Value("${hdfs.uri}")
    private String hdfsUri;

    @Getter
    @Value("${hdfs.baseDir}")
    private final String hdfsBaseDir = "/testdata/images";

    @Bean
    public org.apache.hadoop.fs.FileSystem fileSystem() throws IOException {
        org.apache.hadoop.conf.Configuration config = new org.apache.hadoop.conf.Configuration();
        config.set("fs.defaultFS", hdfsUri);
        return FileSystem.get(config);
    }
}
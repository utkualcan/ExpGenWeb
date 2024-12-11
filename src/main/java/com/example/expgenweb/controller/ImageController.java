package com.example.expgenweb.controller;

import com.example.expgenweb.service.HDFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private HDFSService hdfsService;

    @GetMapping("/{imageName}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String imageName) {
        try {
            byte[] imageData = hdfsService.readImage(imageName);
            if (imageData != null) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(new InputStreamResource(new ByteArrayInputStream(imageData)));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
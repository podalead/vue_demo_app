package org.testerization.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testerization.app.dto.BlogDto;
import org.testerization.app.entity.Blog;
import org.testerization.app.service.BlogService;

@RestController
@RequestMapping("api/blog")
@CrossOrigin
public class BlogController {

    public final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(blogService.getBlogList());
    }

    @PostMapping
    public ResponseEntity<?> postNewBlog(BlogDto blogDto) {
        BlogDto savedBlog = blogService.addNewBlog(blogDto);
        return ResponseEntity.ok(savedBlog);
    }
}

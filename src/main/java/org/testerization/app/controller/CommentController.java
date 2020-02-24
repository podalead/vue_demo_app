package org.testerization.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.testerization.app.dto.BlogDto;
import org.testerization.app.dto.CommentDto;
import org.testerization.app.service.CommentService;

@RestController
@RequestMapping(value = "api/comment")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCommentsByPost(@RequestParam(name = "blodId") Long blodId) {
        BlogDto commentListByBlog = commentService.getCommentListByBlog(blodId);
        return ResponseEntity.ok(commentListByBlog);
    }

    @PostMapping
    public ResponseEntity<?> postCommentForBlog(CommentDto commentDto) {
        CommentDto savedComment = commentService.postCommentForBlog(commentDto, commentDto.getBlogId());
        return ResponseEntity.ok(savedComment);
    }
}

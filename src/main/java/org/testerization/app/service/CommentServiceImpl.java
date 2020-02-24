package org.testerization.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testerization.app.dto.BlogDto;
import org.testerization.app.dto.CommentDto;
import org.testerization.app.entity.Blog;
import org.testerization.app.entity.Comment;
import org.testerization.app.mapper.BlogMapper;
import org.testerization.app.mapper.CommentMapper;
import org.testerization.app.repository.BlogRepository;
import org.testerization.app.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(BlogRepository blogRepository,
                              CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public BlogDto getCommentListByBlog(Long blogId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow();
        return BlogMapper.toDto(blog);
    }

    @Override
    public CommentDto postCommentForBlog(CommentDto commentDto, Long postId) {
        Blog blog = blogRepository.findById(postId)
                .orElseThrow();
        Comment comment = CommentMapper.toEntity(commentDto);
        Comment saveComment = commentRepository.save(comment);
        blog.getComments()
                .add(saveComment);
        blogRepository.save(blog);
        return CommentMapper.toDto(saveComment);
    }
}

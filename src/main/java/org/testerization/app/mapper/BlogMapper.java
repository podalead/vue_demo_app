package org.testerization.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.testerization.app.dto.BlogDto;
import org.testerization.app.entity.Blog;

public class BlogMapper {

    public static Blog toEntity(BlogDto blogDto) {
        return Blog.builder()
                .id(blogDto.getId())
                .title(blogDto.getTitle())
                .message(blogDto.getMessage())
                .username(blogDto.getUsername())
                .createDate(blogDto.getCreateDate())
                .build();
    }

    public static BlogDto toDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .message(blog.getMessage())
                .username(blog.getUsername())
                .createDate(blog.getCreateDate())
                .comments(CommentMapper.toDto(blog.getComments()))
                .build();
    }

    public static List<Blog> toEntity(List<BlogDto> comments) {
        return comments.stream()
                .map(BlogMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<BlogDto> toDto(List<Blog> comments) {
        return comments.stream()
                .map(BlogMapper::toDto)
                .collect(Collectors.toList());
    }
}

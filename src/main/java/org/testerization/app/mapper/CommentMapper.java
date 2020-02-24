package org.testerization.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.testerization.app.dto.CommentDto;
import org.testerization.app.entity.Comment;

public class CommentMapper {

    public static Comment toEntity(CommentDto commentDto) {
        return Comment.builder()
                .message(commentDto.getMessage())
                .username(commentDto.getUsername())
                .build();
    }

    public static CommentDto toDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .message(comment.getMessage())
                .username(comment.getUsername())
                .build();

    }

    public static List<Comment> toEntity(List<CommentDto> comments) {
        return comments.stream()
                .map(CommentMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<CommentDto> toDto(List<Comment> comments) {
        return comments.stream()
                .map(CommentMapper::toDto)
                .collect(Collectors.toList());
    }
}

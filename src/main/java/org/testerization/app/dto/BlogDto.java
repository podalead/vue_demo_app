package org.testerization.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private Long id;
    private String username;

    private String title;
    private String message;
    private LocalDateTime createDate;
    private List<CommentDto> comments;
}

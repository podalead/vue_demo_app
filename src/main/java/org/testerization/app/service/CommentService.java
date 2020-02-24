package org.testerization.app.service;

import org.testerization.app.dto.BlogDto;
import org.testerization.app.dto.CommentDto;

public interface CommentService {

    BlogDto getCommentListByBlog(Long blogId);

    CommentDto postCommentForBlog(CommentDto commentDto, Long postId);
}

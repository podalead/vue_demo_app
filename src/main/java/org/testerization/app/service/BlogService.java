package org.testerization.app.service;

import java.util.List;

import org.testerization.app.dto.BlogDto;

public interface BlogService {

    List<BlogDto> getBlogList();
    BlogDto addNewBlog(BlogDto blogDto);
}

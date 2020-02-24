package org.testerization.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testerization.app.dto.BlogDto;
import org.testerization.app.entity.Blog;
import org.testerization.app.mapper.BlogMapper;
import org.testerization.app.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogDto> getBlogList() {
        List<Blog> blogs = blogRepository.findAll();
        return BlogMapper.toDto(blogs);
    }

    @Override
    public BlogDto addNewBlog(BlogDto blogDto) {
        Blog save = blogRepository.save(BlogMapper.toEntity(blogDto));
        return BlogMapper.toDto(save);
    }
}

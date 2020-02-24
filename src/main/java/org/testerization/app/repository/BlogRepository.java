package org.testerization.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.testerization.app.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}

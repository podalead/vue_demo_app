package org.testerization.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blog")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String message;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "blog_comments",
            joinColumns = @JoinColumn(name = "blog"),
            inverseJoinColumns = @JoinColumn(name = "comment"))
    private List<Comment> comments;
}

package org.testerization.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

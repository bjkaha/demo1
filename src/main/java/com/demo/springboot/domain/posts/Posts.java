package com.demo.springboot.domain.posts;


import com.demo.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Getter
@NoArgsConstructor
@Entity // 카멜케이스에서 언더스코어 네이밍으로 테이블로 연결 SalesManager -> sales_manager
public class Posts extends BaseTimeEntity {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // becomes BIGINT

    @Column(length = 500, nullable = false) // becomes VARCHAR(500)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // becomes TEXT

    private String author; // becomes VARCHAR(255)

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

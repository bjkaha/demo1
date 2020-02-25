package com.demo.springboot.web.dto;

import com.demo.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    // Dto는 Entity와 비슷해보이지만 Entity를 req/response 용으로 사용하면 안됩니다!
    // - Entity는 데이터베이스와 맞닿는 핵심 클래스
    // - Dto는 view를 위한 클래스라 자주 변경 필요
    // - view layer와 DB layer 철저히 분히 필요
    // - controller에서 결과로 여러 테이블 조인해야 할 때도 많기 때문에 entity만으로 부족한 경우가 많음.
    // ** Controller에서 쓸 Dto 와 Entity는 꼭 분리하여 사용!!
}

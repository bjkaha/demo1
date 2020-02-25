package com.demo.springboot.web;

import com.demo.springboot.service.posts.PostsService;
import com.demo.springboot.web.dto.PostsResponseDto;
import com.demo.springboot.web.dto.PostsSaveRequestDto;
import com.demo.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    /*
        스프링에서 Bean을 주입받는 방법:
        (1) @Autowired , (2) setter, (3) 생성자 (constructor)
        * 가장 권장되는 방식은 생성자를 사용하는 것 입니다.
    */
    // @autowired가 없는 이유? -> @RequiredArgsConstructor가 생성자를 대신 생성해.
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}

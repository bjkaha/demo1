package com.demo.springboot.service.posts;

import com.demo.springboot.domain.posts.Posts;
import com.demo.springboot.domain.posts.PostsRepository;
import com.demo.springboot.web.dto.PostsListResponseDto;
import com.demo.springboot.web.dto.PostsResponseDto;
import com.demo.springboot.web.dto.PostsSaveRequestDto;
import com.demo.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    /*
        스프링에서 Bean을 주입받는 방법:
        (1) @Autowired , (2) setter, (3) 생성자 (constructor)
        * 가장 권장되는 방식은 생성자를 사용하는 것 입니다.
    */
    // @autowired가 없는 이유? -> @RequiredArgsConstructor가 생성자를 대신 생성해.
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }


}

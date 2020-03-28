package com.demo.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정없이 @SpringBootTest 하면 H2 데이터베이스 자동으로 실행해줌.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트가 끝날 때 마다 수행됨.
            // 전체 테스트 수행할 때 테스트간 데이터 침범 막기 위해 사용됨
            // 여러 테스트 실행시 h2 데이터베이스에 데이터가 그대로 남아있어 다음 테스트 실행 시 실패할 수 있음.
    public void cleanup() {
        postsRepository.deleteAll();
    }

//    @Test
//    public void 게시글저장_불러오기() {
//        // given
//        String title = "테스트 게시글";
//        String content = "테스트 본문";
//
//        postsRepository.save(Posts.builder()
//                .title(title)
//                .content(content)
//                .author("jojoldu@gmail.com")
//                .build()); // save(..): posts 테이블에 insert/update 쿼리 실행
//        // when
//        List<Posts> postsList = postsRepository.findAll(); // findAll(): 테이블의 모든 데이터 조회해오는 메소드
//        // then
//        Posts posts = postsList.get(0);
//        assertThat(posts.getTitle()).isEqualTo(title);
//        assertThat(posts.getContent()).isEqualTo(content);
//    }

//    @Test
//    public void BaseTimeEntity_등록() {
//        // given
//        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
//        postsRepository.save(Posts.builder()
//            .title("title")
//            .content("content")
//            .author("author")
//            .build());
//
//        // when
//        List<Posts> postsList = postsRepository.findAll();
//        // then
//        Posts posts = postsList.get(0);
//
//        System.out.println(">>>>>>>>> createdDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
//        assertThat(posts.getCreatedDate()).isAfter(now);
//        assertThat(posts.getModifiedDate()).isAfter(now);
//    }
}

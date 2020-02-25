package com.demo.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // JUnit의 내장 실행자 외에 SpringRunner 실행자를 사용하게 함. 스프링부트 테스트와 JUnit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 여러 스프링 테스트 어노테이션 중, Web(SpringMVC)에 집중하게;
                                                // 선언할 시, @Controller, @ControllerAdvice 등 사용가능. @Service, @Component, @Repository 사용 불가능. 여기서는 컨트롤러만 필요해서 선언함.
public class HelloControllerTest {
    @Autowired // 스프링에서 관리하는 Bean을 주입받음.
    private MockMvc mvc; // API 테스트 시 사용. HTTP GET, POST 등 테스트 함.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) // GET 요청
                .andExpect(status().isOk()) // HTTP Header에서 Status=200 검증
                .andExpect(content().string(hello)); // 제대로 된 값을 리턴하는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}

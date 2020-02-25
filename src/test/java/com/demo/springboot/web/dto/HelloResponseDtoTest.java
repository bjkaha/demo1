package com.demo.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        // then
        assertThat(dto.getName()).isEqualTo(name); // assertj 라는 검증 라이브러리; isEqualTo 같으면 성공
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*
        JUnit의 assertThat 와 비교하여 assertj의 assertThat 의 장점:

        * CoreMatchers 와 달리 추가적 라이브러리가 필요하지 않습니다.
        -- jUnit 의 assertThat 사용 시 is()와 같이 CoreMatchers 라이브러리가 필요합니다.

        * 자동완성이 좀 더 확실하게 지원됩니다.
        -- IDE에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약합니다.

        reference : http://bit.ly/30vm9Lg
         */

    }
}

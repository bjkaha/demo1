package com.demo.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 모든 필드에 get 메소드 생성
@RequiredArgsConstructor // 선언된 final 필드가 포함된 생성자를 만듬. final 없는 필드는 포함하지 않음.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}

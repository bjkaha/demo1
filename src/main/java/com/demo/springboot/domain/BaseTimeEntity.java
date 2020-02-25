package com.demo.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식됩니다
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함합니다.
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되고 저장될때 자동 저장됩니다.
    private LocalDateTime createdDate;

    @LastModifiedDate  // 조회한 Entity의 값을 변경할 때 자동 저장됩니다.
    private LocalDateTime modifiedDate;
}

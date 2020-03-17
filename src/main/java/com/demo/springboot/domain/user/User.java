package com.demo.springboot.domain.user;

import com.demo.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) // JPA Database에서 Enum 값을 저장할 때 어떤 형태로 저장할지 결정합니다.
                                // 기본적으로 int의 숫자로 저장됩니다.
                                // 숫자로 저장되면 데이터베이스에서 확인할 때 그 값이 무슨 코드를 의미하는지 알 수 없습니다.
                                // 그래서 문자열 EnumType.STRING 로 저장될 수 있게 선업합니다.
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

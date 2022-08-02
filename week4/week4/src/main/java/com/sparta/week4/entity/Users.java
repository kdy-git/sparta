package com.sparta.week4.entity;

import com.sparta.week4.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Component
@NoArgsConstructor
public class Users {
    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)  // Auto_increment
    private Long userNo;

    @Column(nullable = false)  // not null
    private String username;

    @Column(nullable = false)  // not null
    private String password;

    @Column(nullable = false)  // not null
    private String nickname;

    public Users(UserDto userDto) {
        username = userDto.getUsername();
        password = userDto.getPassword();
        nickname = userDto.getNickname();
    }
    public Users(String id, String password, String nickname) {
        this.username = id;
        this.password = password;
        this.nickname = nickname;
    }

}
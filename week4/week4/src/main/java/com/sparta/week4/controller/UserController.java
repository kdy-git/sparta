package com.sparta.week4.controller;

import com.sparta.week4.dto.UserDto;
import com.sparta.week4.repository.UserRepository;
import com.sparta.week4.security.UserDetailsImpl;
import com.sparta.week4.security.UserDetailsServiceImpl;
import com.sparta.week4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserDetailsImpl userDetails;

    @PostMapping("/user/signup")
    public int signup(@RequestBody UserDto userDto) {
        try {
            userService.signUp(userDto);
            return 0;
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
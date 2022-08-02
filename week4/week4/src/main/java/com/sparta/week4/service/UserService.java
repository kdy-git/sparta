package com.sparta.week4.service;

import com.sparta.week4.dto.UserDto;
import com.sparta.week4.entity.Users;
import com.sparta.week4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public int existId(String id) { // DB에 아이디가 존재하지 않는경우 false 반환하기위한 메서드
        try {
            String DBid = userRepository.findByUsername(id).get().getUsername();
            if(DBid != null) { return 1; } else { return 0; }
        }catch (Exception e) { return 0; }
    }

    public void signUp(UserDto userDto) {

        String id = userDto.getUsername();

        Optional<Users> find_id = userRepository.findByUsername(id);

        if(find_id.isPresent()) {
            throw new IllegalArgumentException("중복된 ID가 존재합니다.");
        }

        String password = passwordEncoder.encode(userDto.getPassword());
        String nickname = userDto.getNickname();

        Users user = new Users(id, password, nickname);
        userRepository.save(user);

    }
}

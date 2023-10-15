package com.wanted.wantedpreonboardingbackend.user.controller;

import com.wanted.wantedpreonboardingbackend.user.controller.dto.UserDto;
import com.wanted.wantedpreonboardingbackend.user.controller.dto.UserDto.ResponseDto;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Users;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    @ResponseBody
    @PostMapping
    public UserDto.ResponseDto registerUser(@RequestBody UserDto.RequestDto requestDto) {
        Users saved = userRepository.save(requestDto.toEntity());
        return new UserDto.ResponseDto(saved);
    }
}

package com.wanted.wantedpreonboardingbackend.user.service;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Users;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}

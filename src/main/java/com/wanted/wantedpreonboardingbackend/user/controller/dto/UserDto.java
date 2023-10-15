package com.wanted.wantedpreonboardingbackend.user.controller.dto;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Users;

public class UserDto {

    public record RequestDto (
        String name
    ) {
        public Users toEntity() {
            return Users.createUsers(name);
        }
    }

    public record ResponseDto (
        Long id,
        String name

    ) {
        public ResponseDto(Users entity) {
            this(
                entity.getId(),
                entity.getName()
            );
        }
    }
}

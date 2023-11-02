package com.wanted.wantedpreonboardingbackend.user.controller.dto;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Users;

public class UserDto {

    public record createRequest(
        String name,
        Long companyId
    ) {
        public Users toEntity() {
            return Users.builder()
                    .name(name)
                    .build();
        }
    }

    public record Response(
        Long id,
        String name

    ) {
        public Response(Users entity) {
            this(
                entity.getId(),
                entity.getName()
            );
        }
    }
}

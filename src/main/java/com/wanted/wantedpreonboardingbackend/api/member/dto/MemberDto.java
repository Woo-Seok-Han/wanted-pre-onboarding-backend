package com.wanted.wantedpreonboardingbackend.api.member.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberDto {

    public record Response(
            Long id,
            Long companyId,
            String name
    ) {}
}

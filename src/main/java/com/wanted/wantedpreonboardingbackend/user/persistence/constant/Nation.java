package com.wanted.wantedpreonboardingbackend.user.persistence.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Nation {

    KOREA("한국"),
    JAPAN("일본"),
    CHINA("중국"),
    VIETNAM("베트남");

    private final String koreanName;
}

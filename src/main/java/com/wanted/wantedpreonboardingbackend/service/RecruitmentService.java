package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.persistence.repository.RecruitmentNoticeDetailRepository;
import com.wanted.wantedpreonboardingbackend.persistence.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final RecruitmentNoticeDetailRepository recruitmentNoticeDetailRepository;

}

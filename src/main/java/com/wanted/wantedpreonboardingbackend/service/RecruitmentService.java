package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto;
import com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto.ResponseDto;
import com.wanted.wantedpreonboardingbackend.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.persistence.repository.RecruitmentNoticeDetailRepository;
import com.wanted.wantedpreonboardingbackend.persistence.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final RecruitmentNoticeDetailRepository recruitmentNoticeDetailRepository;

    public RecruitmentNoticeDto.ResponseDto registerNotice(RecruitmentNoticeDto.RequestDto requestDto) {
        RecruitmentNotice saved =  recruitmentNoticeRepository.save(requestDto.toEntity());
        return new RecruitmentNoticeDto.ResponseDto(saved);
    }
}

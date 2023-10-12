package com.wanted.wantedpreonboardingbackend.service;

import static com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto.RequestDto;

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

    public ResponseDto registerNotice(RequestDto requestDto) {
        RecruitmentNotice saved =  recruitmentNoticeRepository.save(requestDto.toEntity());
        return new ResponseDto(saved);
    }

    public ResponseDto findNotice(final Long id) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        return new ResponseDto(notice);
    }
}

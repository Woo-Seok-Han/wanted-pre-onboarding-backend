package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto;
import com.wanted.wantedpreonboardingbackend.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.persistence.repository.RecruitmentNoticeDetailRepository;
import com.wanted.wantedpreonboardingbackend.persistence.repository.RecruitmentNoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final RecruitmentNoticeDetailRepository recruitmentNoticeDetailRepository;

    public RecruitmentNoticeDto.ResponseDto registerNotice(RecruitmentNoticeDto.RequestDto requestDto) {
        RecruitmentNotice recruitmentNotice = requestDto.toEntity();
        RecruitmentNotice saved = recruitmentNoticeRepository.save(recruitmentNotice);

        return new RecruitmentNoticeDto.ResponseDto(saved);
    }

    public RecruitmentNoticeDto.ResponseDto getNotice(Long id) {
        RecruitmentNotice finded = recruitmentNoticeRepository.findById(id)
                .orElseThrow(() -> (new RuntimeException("채용공고가 없습니다.")));

        return new RecruitmentNoticeDto.ResponseDto(finded);
    }

    @Transactional
    public RecruitmentNoticeDto.ResponseDto updateNotice(Long id, RecruitmentNoticeDto.RequestDto requestDto) {
        RecruitmentNotice found = recruitmentNoticeRepository.findById(id)
                .orElseThrow(() -> (new RuntimeException("채용공고가 없습니다.")));

        found.update(requestDto);
        return new RecruitmentNoticeDto.ResponseDto(found);
    }

    public void deleteNotice(List<Long> ids) {
        recruitmentNoticeRepository.deleteAllById(ids);
    }
}

package com.wanted.wantedpreonboardingbackend.recruitment.service;

import static com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.RequestDto;

import com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.ResponseDto;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.repository.RecruitmentNoticeDetailRepository;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.repository.RecruitmentNoticeRepository;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.entity.CompanyRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final CompanyRepository companyRepository;
    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final RecruitmentNoticeDetailRepository recruitmentNoticeDetailRepository;

    @Transactional
    public ResponseDto registerNotice(RequestDto requestDto) {
        Company company = companyRepository.findById(requestDto.companyId())
            .orElseThrow(() -> new IllegalStateException("해당 회사가 존재하지 않습니다."));

        RecruitmentNotice notice = requestDto.toEntity(company);
        log.info("entity 변환");
        company.addRecruitmentNotice(notice);
        log.info("연관관계 매핑");
        RecruitmentNotice saved = recruitmentNoticeRepository.save(notice);
        log.info("saved!!");

        return new ResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public ResponseDto findNotice(final Long id) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        return new ResponseDto(notice);
    }

    @Transactional(readOnly = true)
    public List<ResponseDto> findAllNotice() {
        List<RecruitmentNotice> noticeList = recruitmentNoticeRepository.findAll();
        return noticeList.stream().map(ResponseDto::new).toList();
    }

    @Transactional
    public ResponseDto modifyNotice(final Long id, RequestDto requestDto) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        notice.update(requestDto);
        return new ResponseDto(notice);
    }

    @Transactional
    public void deleteNotice(final Long id) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        recruitmentNoticeRepository.delete(notice);
    }
}

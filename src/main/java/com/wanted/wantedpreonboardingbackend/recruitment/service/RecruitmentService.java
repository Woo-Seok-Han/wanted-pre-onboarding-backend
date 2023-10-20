package com.wanted.wantedpreonboardingbackend.recruitment.service;

import com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.Response;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNoticeDetail;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.repository.RecruitmentNoticeRepository;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.entity.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.RequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final CompanyRepository companyRepository;
    private final RecruitmentNoticeRepository recruitmentNoticeRepository;

    @Transactional
    public Response registerNotice(RequestDto requestDto) {
        Company company = companyRepository.findById(requestDto.companyId())
            .orElseThrow(() -> new IllegalStateException("해당 회사가 존재하지 않습니다."));

        RecruitmentNoticeDetail recruitmentNoticeDetail = RecruitmentNoticeDetail.create(
            requestDto.content());

        RecruitmentNotice notice = requestDto.toEntity();
        notice.updateRecruitmentNoticeDetail(recruitmentNoticeDetail);
        company.addRecruitmentNotice(notice);

        return Response.of(recruitmentNoticeRepository.save(notice));
    }

    @Transactional(readOnly = true)
    public Response findNotice(final Long id) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        return Response.of(notice);
    }

    @Transactional(readOnly = true)
    public List<Response> findAllNotice() {
        List<RecruitmentNotice> noticeList = recruitmentNoticeRepository.findAll();
        return noticeList.stream().map(Response::of).toList();
    }

    @Transactional
    public Response modifyNotice(final Long id, RequestDto requestDto) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        notice.update(requestDto);
        return Response.of(notice);
    }

    @Transactional
    public void deleteNotice(final Long id) {
        RecruitmentNotice notice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("해당하는 채용 공고가 존재하지 않습니다."));
        recruitmentNoticeRepository.delete(notice);
    }
}

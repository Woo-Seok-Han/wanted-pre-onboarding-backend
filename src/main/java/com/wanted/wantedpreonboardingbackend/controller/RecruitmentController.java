package com.wanted.wantedpreonboardingbackend.controller;

import static com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto.RequestDto;
import static com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto.ResponseDto;

import com.wanted.wantedpreonboardingbackend.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recruitment")
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @ResponseBody
    @PostMapping("/notice")
    public ResponseDto registerRecruitmentNotice(RequestDto requestDto) {
        return recruitmentService.registerNotice(requestDto);
    }

}

package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto;
import com.wanted.wantedpreonboardingbackend.service.RecruitmentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/recruitment")
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @ResponseBody
    @GetMapping(value = "/sample-api/{sample-param}")
    public String sampleApi (@PathVariable("sample-param") String sampleParam) {
        return "This is your sample parameter : " + sampleParam;
    }

    @ResponseBody
    @GetMapping("{id}")
    public RecruitmentNoticeDto.ResponseDto getNotice(@PathVariable("id") final Long id) {
        return recruitmentService.getNotice(id);
    }

    @ResponseBody
    @PostMapping
    public RecruitmentNoticeDto.ResponseDto registerNotice(final RecruitmentNoticeDto.RequestDto recruitmentNoticeRequestDto) {
        return recruitmentService.registerNotice(recruitmentNoticeRequestDto);
    }

    @ResponseBody
    @PutMapping("{id}")
    public RecruitmentNoticeDto.ResponseDto modifyNotice(@PathVariable("id") final Long id, @RequestBody RecruitmentNoticeDto.RequestDto recruitmentNoticeRequestDto) {
        return recruitmentService.updateNotice(id, recruitmentNoticeRequestDto);
    }

    @ResponseBody
    @DeleteMapping
    public String deleteNotice(@RequestBody List<Long> ids) {
        recruitmentService.deleteNotice(ids);
        return "삭제 되었습니다.";
    }
}

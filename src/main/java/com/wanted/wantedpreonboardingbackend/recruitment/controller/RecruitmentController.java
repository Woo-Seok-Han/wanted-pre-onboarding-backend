package com.wanted.wantedpreonboardingbackend.recruitment.controller;

import static com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.RequestDto;
import static com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.Response;

import com.wanted.wantedpreonboardingbackend.recruitment.service.RecruitmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Response registerRecruitmentNotice(RequestDto requestDto) {
        return recruitmentService.registerNotice(requestDto);
    }

    @ResponseBody
    @GetMapping("/notice/{id}")
    public Response findRecruitmentNotice(@PathVariable(name = "id") final Long id) {
        return recruitmentService.findNotice(id);
    }

    @ResponseBody
    @GetMapping("/notice/list")
    public List<Response> findRecruitmentNotice() {
        return recruitmentService.findAllNotice();
    }

    @ResponseBody
    @PutMapping("/notice/{id}")
    public Response modifyRecruitmentNotice(@PathVariable(name = "id") final Long id, RequestDto requestDto) {
        return recruitmentService.modifyNotice(id, requestDto);
    }

    @ResponseBody
    @DeleteMapping("notice/{id}")
    public String deleteRecruitmentNotice(@PathVariable(name = "id") final Long id) {
        recruitmentService.deleteNotice(id);
        return "채용공고가 삭제 되었습니다.";
    }
}

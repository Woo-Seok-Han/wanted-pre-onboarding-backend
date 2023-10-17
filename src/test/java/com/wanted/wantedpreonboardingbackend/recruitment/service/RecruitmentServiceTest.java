package com.wanted.wantedpreonboardingbackend.recruitment.service;

import static org.junit.jupiter.api.Assertions.*;

import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.repository.RecruitmentNoticeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecruitmentServiceTest {

    @Autowired
    public RecruitmentNoticeRepository recruitmentNoticeRepository;

    @Test
    @DisplayName("채용 공고 등록")
    void registerNotice() {

        // given
        Long id = 3L;
        String companyName = "테스트 회사";
        int compensationAmount = 50000;



        // when

        // then
    }

    @Test
    @DisplayName("채용 공고 단건 찾기")
    void findNotice() {
    }

    @Test
    @DisplayName("채용 공고 전체 찾기")
    void findAllNotice() {
    }

    @Test
    @DisplayName("채용 공고 수정하기")
    void modifyNotice() {
    }

    @Test
    @DisplayName("채용 공고 삭제하기")
    void deleteNotice() {
    }
}
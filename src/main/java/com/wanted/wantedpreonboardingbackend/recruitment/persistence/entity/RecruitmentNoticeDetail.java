package com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RecruitmentNoticeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_notice_detail_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_notice_id")
    private RecruitmentNotice recruitmentNotice;

    private String content;

    private RecruitmentNoticeDetail(String content) {
        this.id = null;
        this.content = content;
    }

    public static RecruitmentNoticeDetail create(String content) {
        return new RecruitmentNoticeDetail(content);
    }

    public void updateRecruitmentNotice(RecruitmentNotice recruitmentNotice) {
        this.recruitmentNotice = recruitmentNotice;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}

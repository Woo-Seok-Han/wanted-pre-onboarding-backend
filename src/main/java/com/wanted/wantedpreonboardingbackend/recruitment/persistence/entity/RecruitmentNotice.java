package com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity;

import com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto.RequestDto;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.constant.RequirementSkill;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RecruitmentNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_notice_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private int compensationAmount;

    private String position;

    @Enumerated(EnumType.STRING)
    private RequirementSkill requirementSkill;

    @OneToOne(mappedBy = "recruitmentNotice", cascade = CascadeType.ALL)
    private RecruitmentNoticeDetail recruitmentNoticeDetail;

    public RecruitmentNotice(int compensationAmount, String position,
        RequirementSkill requirementSkill) {
        this.company = null;
        this.compensationAmount = compensationAmount;
        this.position = position;
        this.requirementSkill = requirementSkill;
    }

    public void update(RequestDto requestDto) {
        this.compensationAmount = requestDto.compensationAmount();;
        this.position = requestDto.position();
        this.requirementSkill = requestDto.requirementSkill();
        this.recruitmentNoticeDetail.updateContent(requestDto.content());
    }

    public void updateCompany(Company company) {
        this.company = company;
    }

    public void updateRecruitmentNoticeDetail(RecruitmentNoticeDetail recruitmentNoticeDetail) {
        this.recruitmentNoticeDetail = recruitmentNoticeDetail;
        recruitmentNoticeDetail.updateRecruitmentNotice(this);
    }
}

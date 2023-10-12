package com.wanted.wantedpreonboardingbackend.persistence.entity;

import com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto.RequestDto;
import com.wanted.wantedpreonboardingbackend.persistence.entity.constant.RequirementSkill;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    private Long companyId;

    private int compensationAmount;

    private String position;

    private String content;

    @Enumerated(EnumType.STRING)
    private RequirementSkill requirementSkill;

    @OneToMany(mappedBy = "recruitmentNotice", cascade = CascadeType.ALL)
    private List<RecruitmentNoticeDetail> recruitmentNoticeDetails;

    public RecruitmentNotice(Long companyId, int compensationAmount, String position, String content,
        RequirementSkill requirementSkill) {
        this.companyId = companyId;
        this.compensationAmount = compensationAmount;
        this.position = position;
        this.content = content;
        this.requirementSkill = requirementSkill;
    }

    public void update(RequestDto requestDto) {
        this.compensationAmount = requestDto.compensationAmount();;
        this.position = requestDto.position();
        this.content = requestDto.content();
        this.requirementSkill = requestDto.requirementSkill();
    }
}

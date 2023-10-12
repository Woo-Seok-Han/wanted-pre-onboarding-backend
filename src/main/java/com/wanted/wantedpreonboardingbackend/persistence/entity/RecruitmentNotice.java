package com.wanted.wantedpreonboardingbackend.persistence.entity;

import com.wanted.wantedpreonboardingbackend.controller.dto.RecruitmentNoticeDto;
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

import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class RecruitmentNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_notice_id")
    private Long id;

    private Long companyId;

    private String position;

    private int compensationAmount;

    private String content;

    @Enumerated(EnumType.STRING)
    private RequirementSkill requirementSkill;

    @OneToMany(mappedBy = "recruitmentNotice", cascade = CascadeType.ALL)
    private List<RecruitmentNoticeDetail> recruitmentNoticeDetails;

    public void update(RecruitmentNoticeDto.RequestDto updateDto) {
        this.companyId = updateDto.companyId();
        this.position = updateDto.position();
        this.compensationAmount = updateDto.compensationAmount();
        this.content = updateDto.content();
        this.requirementSkill = updateDto.requirementSkill();
    }
}

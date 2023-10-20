package com.wanted.wantedpreonboardingbackend.recruitment.controller.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.constant.RequirementSkill;
import com.wanted.wantedpreonboardingbackend.user.persistence.constant.Nation;

public class RecruitmentNoticeDto {
    public record RequestDto (
        Long companyId,
        String position,
        int compensationAmount,
        String content,
        RequirementSkill requirementSkill
    ) {
        public RecruitmentNotice toEntity(){
            return new RecruitmentNotice(
                compensationAmount,
                position,
                requirementSkill
            );
        }
    }

    public record Response(
        Long id,
        String companyName,
        String nationKRName,
        String region,
        String position,
        int compensation,
        String content,
        RequirementSkill requirementSkill
    ) {

        public static Response of(RecruitmentNotice entity) {
            return new Response(
                entity.getId(),
                entity.getCompany().getName(),
                entity.getCompany().getNation().getKoreanName(),
                entity.getCompany().getRegion(),
                entity.getPosition(),
                entity.getCompensationAmount(),
                entity.getRecruitmentNoticeDetail().getContent(),
                entity.getRequirementSkill()
            );
        }
    }

}

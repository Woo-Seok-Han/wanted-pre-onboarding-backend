package com.wanted.wantedpreonboardingbackend.recruitment.controller.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.constant.RequirementSkill;

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
        String position,
        int compensation,
        String content,
        RequirementSkill requirementSkill
    ) {
        public Response(
            Long id,
            String companyName,
            String position,
            int compensation,
            String content,
            RequirementSkill requirementSkill
        ) {
            this.id = id;
            this.companyName = companyName;
            this.position = position;
            this.compensation = compensation;
            this.content = content;
            this.requirementSkill = requirementSkill;
        }

        public static Response of(RecruitmentNotice entity) {
            return new Response(
                entity.getId(),
                entity.getCompany().getName(),
                entity.getPosition(),
                entity.getCompensationAmount(),
                entity.getRecruitmentNoticeDetail().getContent(),
                entity.getRequirementSkill()
            );
        }
    }

}

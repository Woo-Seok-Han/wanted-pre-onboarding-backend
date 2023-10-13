package com.wanted.wantedpreonboardingbackend.recruitment.controller.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.constant.RequirementSkill;

public class RecruitmentNoticeDto {
    /* {
            "회사_id":회사_id,
            "채용포지션":"백엔드 주니어 개발자",
            "채용보상금":1000000,
            "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
            "사용기술":"Python"
        } */
    public static record RequestDto (
        Long companyId,
        String position,
        int compensationAmount,
        String content,
        RequirementSkill requirementSkill
    ) {
        public RecruitmentNotice toEntity(){
            return new RecruitmentNotice(
                companyId,
                compensationAmount,
                position,
                content,
                requirementSkill
            );
        }
    }

    public static record ResponseDto(
        Long companyId,
        String position,
        int compensation,
        String content,
        RequirementSkill requirementSkill
    ) {
        public ResponseDto(RecruitmentNotice entity) {
            this(
                entity.getCompanyId(),
                entity.getPosition(),
                entity.getCompensationAmount(),
                entity.getContent(),
                entity.getRequirementSkill()
            );
        }
    }

}

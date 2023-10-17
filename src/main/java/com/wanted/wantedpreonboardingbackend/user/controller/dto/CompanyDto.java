package com.wanted.wantedpreonboardingbackend.user.controller.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto;
import com.wanted.wantedpreonboardingbackend.recruitment.persistence.entity.RecruitmentNotice;
import com.wanted.wantedpreonboardingbackend.user.persistence.constant.Nation;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import java.util.List;

public class CompanyDto {

    public record RequestDto (
        String name,
        Nation nation,
        String region
    ) {
        public Company toEntity() {
            return Company.createCompany(name, nation, region);
        }
    }

    public record ResponseDto (
        Long id,
        String name,
        Nation nation,
        String region,
        List<RecruitmentNoticeDto.ResponseDto> recruitmentNoticeDtoList

    ) {
        public ResponseDto(Company entity) {
            this(
                entity.getId(),
                entity.getName(),
                entity.getNation(),
                entity.getRegion(),
                entity.getRecruitmentNoticeList().stream()
                    .map(RecruitmentNoticeDto.ResponseDto::new)
                    .toList()
            );
        }
    }
}

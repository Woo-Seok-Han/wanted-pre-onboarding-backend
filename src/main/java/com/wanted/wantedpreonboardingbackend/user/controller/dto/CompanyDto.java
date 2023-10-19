package com.wanted.wantedpreonboardingbackend.user.controller.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.controller.dto.RecruitmentNoticeDto;
import com.wanted.wantedpreonboardingbackend.user.persistence.constant.Nation;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import java.util.List;

public class CompanyDto {

    public record Request(
        String name,
        Nation nation,
        String region
    ) {
        public Company toEntity() {
            return Company.create(name, nation, region);
        }
    }

    public record Response(
        Long id,
        String name,
        Nation nation,
        String region,
        List<RecruitmentNoticeDto.Response> recruitmentNoticeDtoList

    ) {
        public Response(Long id, String name, Nation nation, String region,
            List<RecruitmentNoticeDto.Response> recruitmentNoticeDtoList) {
            this.id = id;
            this.name = name;
            this.nation = nation;
            this.region = region;
            this.recruitmentNoticeDtoList = recruitmentNoticeDtoList;
        }

        public static Response of(Company entity){
            return new Response(
                entity.getId(),
                entity.getName(),
                entity.getNation(),
                entity.getRegion(),
                entity.getRecruitmentNoticeList().stream()
                    .map(RecruitmentNoticeDto.Response::of)
                    .toList()
            );
        }
    }
}

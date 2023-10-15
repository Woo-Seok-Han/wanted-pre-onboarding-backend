package com.wanted.wantedpreonboardingbackend.user.controller;

import com.wanted.wantedpreonboardingbackend.user.controller.dto.CompanyDto;
import com.wanted.wantedpreonboardingbackend.user.persistence.constant.Nation;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.entity.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;
    @PostMapping
    public CompanyDto.ResponseDto registerCompany(@RequestBody CompanyDto.RequestDto requestDto) {
        Company saved = companyRepository.save(requestDto.toEntity());
        return new CompanyDto.ResponseDto(saved);
    }
}

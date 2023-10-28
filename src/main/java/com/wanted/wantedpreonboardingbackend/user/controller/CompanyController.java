package com.wanted.wantedpreonboardingbackend.user.controller;

import com.wanted.wantedpreonboardingbackend.user.controller.dto.CompanyDto.Request;
import com.wanted.wantedpreonboardingbackend.user.controller.dto.CompanyDto.Response;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Response registerCompany(@RequestBody Request request) {
        Company saved = companyRepository.save(request.toEntity());
        return Response.of(saved);
    }

    @GetMapping("/{id}")
    public Response findCompany(@PathVariable(name = "id") Long id) {
        Company company = companyRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("회사가 존재하지 않습니다."));

        return Response.of(company);
    }
}

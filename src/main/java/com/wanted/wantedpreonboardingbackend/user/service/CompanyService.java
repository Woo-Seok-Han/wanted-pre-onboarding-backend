package com.wanted.wantedpreonboardingbackend.user.service;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company findCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalStateException("회사가 존재하지 않습니다."));
    }


}

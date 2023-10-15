package com.wanted.wantedpreonboardingbackend.user.persistence.entity.entity;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}

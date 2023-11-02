package com.wanted.wantedpreonboardingbackend.user.persistence.entity.repository;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Company;
import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}

package com.wanted.wantedpreonboardingbackend.user.persistence.entity.entity;

import com.wanted.wantedpreonboardingbackend.user.persistence.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Long> {

}

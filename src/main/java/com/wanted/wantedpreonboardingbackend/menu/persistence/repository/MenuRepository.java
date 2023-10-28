package com.wanted.wantedpreonboardingbackend.menu.persistence.repository;

import com.wanted.wantedpreonboardingbackend.menu.persistence.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}

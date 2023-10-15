package com.wanted.wantedpreonboardingbackend.user.persistence.entity;

import com.wanted.wantedpreonboardingbackend.user.persistence.constant.Nation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Nation nation;

    private String region;

    private Company(String name, Nation nation, String region) {
        this.id = null;
        this.name = name;
        this.nation = nation;
        this.region = region;
    }

    public static Company createCompany(String name, Nation nation, String region) {
        return new Company(name, nation, region);
    }
}

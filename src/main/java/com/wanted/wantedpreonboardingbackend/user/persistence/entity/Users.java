package com.wanted.wantedpreonboardingbackend.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "user_name")
    private String name;

    @Builder
    private Users(String name) {
        this.id = null;
        this.name = name;
    }

    public void updateCompany(Company company) {
        this.company = company;
    }
}

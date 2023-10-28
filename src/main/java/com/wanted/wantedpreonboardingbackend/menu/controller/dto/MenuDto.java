package com.wanted.wantedpreonboardingbackend.menu.controller.dto;


import com.wanted.wantedpreonboardingbackend.menu.persistence.entity.Menu;

public class MenuDto {

    public record HeaderRequest (
        String menuName,
        String menuUrl
    ) {

    }

    public record HeaderResponse(
        String menuName,
        String menuUrl

    ) {
        public static HeaderResponse of(Menu menu){
            return new HeaderResponse(
                menu.getName(),
                menu.getUrl()
            );
        }
    }
}

package com.wanted.wantedpreonboardingbackend.menu.controller;

import com.wanted.wantedpreonboardingbackend.menu.controller.dto.MenuDto;
import com.wanted.wantedpreonboardingbackend.menu.controller.dto.MenuDto.HeaderResponse;
import com.wanted.wantedpreonboardingbackend.menu.persistence.entity.Menu;
import com.wanted.wantedpreonboardingbackend.menu.persistence.repository.MenuRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuRepository menuRepository;
    @GetMapping("/header")
    public List<MenuDto.HeaderResponse> findHeaderMenu() {

        List<Menu> menuList = menuRepository.findAll();
        return menuList.stream()
            .map(HeaderResponse::of)
            .toList();
    }

    @PostMapping
    public Menu createMenu(@RequestBody MenuDto.HeaderRequest request) {
        Menu menu = new Menu(
            request.menuName(),
            request.menuUrl()
        );

        return menuRepository.save(menu);
    }

    @GetMapping
    public List<Menu> getMenuList() {
        return menuRepository.findAll();
    }

    @DeleteMapping(value = "/{menuId}")
    public String deleteMenu(@PathVariable(name = "menuId") Long id) {
        menuRepository.deleteById(id);
        return "삭제 되었습니다.";
    }

}

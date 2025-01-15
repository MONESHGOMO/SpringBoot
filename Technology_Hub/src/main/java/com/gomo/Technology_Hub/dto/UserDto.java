package com.gomo.Technology_Hub.dto;

import com.gomo.Technology_Hub.enums.AppUserRole;

public class UserDto {

    private Long id;
    private String email;
    private String name;
    private AppUserRole role;


    public UserDto(Long id, String email, String name, AppUserRole role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public UserDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }
}

package com.gomo.Technology_Hub.model;

import com.gomo.Technology_Hub.enums.AppUserRole;
import jakarta.persistence.*;


@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String email;

    private String password;


    @Enumerated(EnumType.STRING) // Maps the enum as a string (e.g., "ADMIN", "USER")
    private AppUserRole role;

    @Lob
    private byte [] img;



    public AppUser() {}

    public AppUser(Long id, String userName, String email, String password, AppUserRole role, byte[] img) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}

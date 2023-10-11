package com.login.jdbclogin.Registration;

import lombok.*;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customerprofile")
@Entity
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    String name;
    @Column(name = "username")
    String username;
    @Column(name = "password",nullable=false)
    String password;
    @Column(name = "email",nullable=false, unique=true)
    String  email;

//    @Column(name = "locked")
//    private Boolean locked = false;
//
//    @Column(name = "enabled")
//    private Boolean enabled = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

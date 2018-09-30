package com.wia.jwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    @Setter
    @Getter
    private Long id;
    @Column(unique = true)
    @Setter
    @Getter
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @Setter
    @Getter
    private Collection<AppRole> roles= new ArrayList<>();

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}

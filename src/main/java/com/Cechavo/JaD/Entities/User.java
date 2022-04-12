package com.Cechavo.JaD.Entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column (name="user_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Definition of Users MySQL table
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable= false, length = 64)
    private String password;
    @Column(nullable=false, unique=true, length=20)
    private String nick;
    @Column(columnDefinition ="tinyint(1) default = 1")
    private boolean enabled = true;

    //Roles for admin[1]/player[2]/DM - DungeonMaster[3]
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

    //gettery/settery


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}


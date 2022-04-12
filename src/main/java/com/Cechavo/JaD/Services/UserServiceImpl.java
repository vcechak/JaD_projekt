package com.Cechavo.JaD.Services;

import com.Cechavo.JaD.Entities.Role;
import com.Cechavo.JaD.Entities.User;
import com.Cechavo.JaD.Repositories.RoleRepository;
import com.Cechavo.JaD.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public int getPrincipalId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        int currentPrincipalID = userRepo.findByNick(currentPrincipalName).getId().intValue();

        System.out.println(currentPrincipalName);
        return currentPrincipalID;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<Role> listRoles() {
        return roleRepo.findAll();
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public RoleRepository getRoleRepo() {
        return roleRepo;
    }

    public void setRoleRepo(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }
}

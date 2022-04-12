package com.Cechavo.JaD.Services;

import com.Cechavo.JaD.Entities.Hero;
import com.Cechavo.JaD.Entities.Role;
import com.Cechavo.JaD.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    /*void registerDefaultUser(User user);*/
    User get(Long id);
    List<Role> listRoles();
    List<User> listAll();
    public void save(User user);
    public int getPrincipalId();
}

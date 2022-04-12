package com.Cechavo.JaD.Controllers;

import com.Cechavo.JaD.Entities.Role;
import com.Cechavo.JaD.Entities.User;
import com.Cechavo.JaD.Repositories.RoleRepository;
import com.Cechavo.JaD.Repositories.UserRepository;
import com.Cechavo.JaD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepo;

    //získání ID přihlášeného uživatele
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public long getCurrentUserName() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();

    long currentPrincipalID = userRepo.findByNick(currentPrincipalName).getId();

        System.out.println(currentPrincipalName);
        return currentPrincipalID;
    }

    @GetMapping("/register")
    public ModelAndView newUser() {
        User user = new User();
        ModelAndView mav = new ModelAndView("user_register");
        mav.addObject("user", user);

        //přidá kolekci Objektu rolí do modelu usera
        List<Role> roles = (List<Role>) roleRepo.findAll();
            roles.remove(0);
        mav.addObject("allRoles", roles);

        return mav;
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);

        return "register_success";
    }

    @GetMapping("/users/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id) {
        User user = userService.get(id);
        ModelAndView mav = new ModelAndView("user_edit");
        mav.addObject("user", user);

        List<Role> roles = (List<Role>) roleRepo.findAll();

        mav.addObject("allRoles", roles);

        return mav;
    }

    @GetMapping("/users/edit/editSelf")
    public ModelAndView editYourself() {
        User user = userRepo.getById(Long.valueOf(userService.getPrincipalId()));
        ModelAndView mav = new ModelAndView("user_edit");
        mav.addObject("user", user);

        List<Role> roles = (List<Role>) roleRepo.findAll();

        mav.addObject("allRoles", roles);

        return mav;
    }


    //User deleting
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId) {
        userRepo.deleteById(userId);
        return "redirect:/users";
    }

    //User list:
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}

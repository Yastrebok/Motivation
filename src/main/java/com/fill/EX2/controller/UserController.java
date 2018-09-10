package com.fill.EX2.controller;

import com.fill.EX2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fill.EX2.service.UserService.UserDto;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUserDto());
        return "usersList";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserDtoById(id));
        return "userDetail";
    }

    @GetMapping("/addUser")
    public String createUserPage() {
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") UserDto user) {
        userService.saveUserDto(user);
        return "redirect:/users/all";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserDtoById(id);
        return "redirect:/users/all";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserDtoById(id));
        return "editUser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDto user) {
        userService.updateUserDto(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/{id}/sum")
    public String getResultSum(@PathVariable("id") Integer user_id, Model model){
        UserDto userDto = userService.getUserResult(user_id);
        model.addAttribute("userResult", userDto.getResultList() );
        log.info(userService.getUserResult(user_id).toString());
        model.addAttribute("user_name", userDto.getUsername());
        return "userGetResult";
    }


}

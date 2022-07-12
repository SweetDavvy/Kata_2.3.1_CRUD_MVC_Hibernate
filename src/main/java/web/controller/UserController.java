package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String welcome() {

        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.index());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping(value = "users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.show(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.show(id));
        return "show";
    }
}


package web.controller;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String listUser (ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser (@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserId(id));
        return "showUser";
    }

    @GetMapping("/new")
    public String newUser (ModelMap model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/showUser";
    }

    @GetMapping("/{id}/update")
    public String setUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserId(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String set(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "showUser";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUserId(id);
        return "redirect:/users";
    }
}

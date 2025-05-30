package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @GetMapping()
    public String showRegistrationForm() {
        return "register"; // имя шаблона для регистрации
    }
    @PostMapping()
    public String registerUser(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam(required = false) String middleName,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               Model model) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            model.addAttribute("error", "Имя и фамилия обязательны для заполнения.");
            return "register";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Пароли не совпадают.");
            return "register";
        }

        if (userService.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Пользователь с таким email уже существует.");
            return "register";
        }

        User user = new User(lastName, firstName, middleName, email);
        user.setPassword(passwordEncoder.encode(password));

        userService.save(user);

        return "redirect:/login";
    }
}


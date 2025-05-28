package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.security.UserDetails;
import com.recommender.recommenderAlgorithm.services.PersonalRecommendationsService;
import com.recommender.recommenderAlgorithm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "api/users")
public class UserController {
    private final UserService userService;
    private final PersonalRecommendationsService personalRecommendationsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserController(UserService userService, PersonalRecommendationsService personalRecommendationsService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.personalRecommendationsService = personalRecommendationsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("currentUser", currentUser);
        return "personalAccount";
    }
    @PostMapping("/edit")
    public String editUser(
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) String email,
            @RequestParam String oldPassword,
            @RequestParam(required = false) String newPassword,
            @RequestParam(required = false) String confirmNewPassword,
            Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("currentUser", currentUser);
        if (!bCryptPasswordEncoder.matches(oldPassword, currentUser.getPassword())) {
            model.addAttribute("error", "Неверный текущий пароль");
            return "personalAccount";
        }

        if(surname != null && !surname.isEmpty())
            currentUser.setUserSurname(surname);
        if(name != null && !name.isEmpty())
            currentUser.setUserName(name);
        if(middleName !=null && !middleName.isEmpty())
            currentUser.setUserMiddleName(middleName);

        if (email != null && !email.isEmpty()) {
            currentUser.setEmail(email);
        }

        if (newPassword != null && !newPassword.isEmpty()) {
            if (!newPassword.equals(confirmNewPassword)) {
                model.addAttribute("error", "Новые пароли не совпадают");
                return "personalAccount";
            }
            currentUser.setPassword(bCryptPasswordEncoder.encode(newPassword));
        }

        userService.save(currentUser);
        User updatedUser = userService.getCurrentUser();
        model.addAttribute("currentUser", updatedUser);
        return "redirect:/api/users/personalAccount"; // перенаправление на страницу профиля
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/personalAccount")
    public String getUser(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.getCurrentUser();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("recommendations",
                personalRecommendationsService.recommendationsForCertainUser(currentUser.getId()));
        return "personalAccount";
    }
}
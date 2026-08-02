package com.ragisteration.login.web;

import com.ragisteration.login.service.UserService;
import com.ragisteration.login.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    @Autowired
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        
        super();
        this.userService = userService;
        
    }
    
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    //to handle html
   /* @GetMapping
   public String showRegistrationForm() {
       return "registration";
   } */
    @GetMapping("/get")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
       return "registration";
   }

    @PostMapping("/post")
    public String registrationUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}

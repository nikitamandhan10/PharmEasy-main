package com.example.PharmEasy.User.Controller;
import com.example.PharmEasy.User.Model.UserModel;
import com.example.PharmEasy.User.Service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    private UserInterface userRepo;

    @GetMapping("/")
    public String viewHomePage() {
        return "Login";
    }

    @GetMapping("/signup_form")
    public String showRegistrationForm(UserModel user) {
        userRepo.save(user);
        return "Register_Complete";
    }

    @GetMapping("/login")
    public String verifyUser(@RequestParam(value = "email", required = true) String email,
                              @RequestParam(value = "password", required = true) String password) {
        UserModel userDetails = userRepo.findItemByEmail(email);
        if(password.equals(userDetails.getPassword()))
            return "Index";
        else
            return "false";
    }



}


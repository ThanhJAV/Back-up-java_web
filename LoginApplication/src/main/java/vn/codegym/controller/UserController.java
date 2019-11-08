package vn.codegym.controller;

import vn.codegym.dao.UserDAO;
import vn.codegym.model.Login;
import vn.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Login;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/pages/view1", "login", new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDAO.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("/pages/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/pages/user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}



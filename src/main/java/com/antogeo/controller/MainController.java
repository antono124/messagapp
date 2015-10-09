package com.antogeo.controller;

import com.antogeo.entity.Message;
import com.antogeo.form.ColorForm;
import com.antogeo.form.LoginForm;
import com.antogeo.observer.ChooseColorNotificationObserver;
import com.antogeo.service.MessageService;
import com.antogeo.service.UserService;
import com.antogeo.utils.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChooseColorNotificationObserver obs;

    @Autowired
    private MessageService messageService;


    @RequestMapping(value = { "/", "/login" }, method = {RequestMethod.GET, RequestMethod.POST})
      public String login(@RequestParam(value = "error", required = false) String error,
                          @RequestParam(value = "logout", required = false) String logout,
                          Model model) {

        if (error != null) {
            model.addAttribute("error","Invalid username or password!" );
        }

        if (logout != null) {
            model.addAttribute("msg","You've been logged out successfully." );
        }

        model.addAttribute("loginForm", new LoginForm());

        return "login";
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){

        model.addAttribute("colorForm", new ColorForm());

        return "dashboard";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){

        return "admin";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model) {

        return "403";

    }

    @RequestMapping(value = "chooseColor", method = RequestMethod.GET)
    public String chooseColor(@Valid @ModelAttribute(value = "colorForm") ColorForm colorForm, Principal principal){

        Color colorEnum;

        if(colorForm.getColor().equals("green")){

            colorEnum = Color.GREEN;

        }else{

            colorEnum = Color.RED;

        }

        userService.addObserver(obs);
        userService.saveColor(colorEnum, principal);

        return "dashboard";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String viewMessages(Model model){

       List<Message> messages = messageService.getMessages();

       model.addAttribute("messages", messages);

       return "messages";
    }

}
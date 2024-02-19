package com.jac.alexandria.Alexandria.Library.controller;

import com.jac.alexandria.Alexandria.Library.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/showFormForSign-Up")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "sign-up";
    }

}
package jvm.ea.ecommerceapp.controller;

import jvm.ea.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {


    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
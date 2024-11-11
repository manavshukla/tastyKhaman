package com.aone.corelibrary.manav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestMain {

    @GetMapping("/hello")
    public String home() {
        return "Hello manav";
    }
}

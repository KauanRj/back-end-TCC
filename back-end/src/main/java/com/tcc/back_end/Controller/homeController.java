package com.tcc.back_end.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class backController {

    @GetMapping
    public String home(){
        return "Back-End funcionando!!";
    }
}

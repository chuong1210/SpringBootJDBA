package springboot2.springbootdemo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroler {

    @Value("${welcome.message}")
    private String welcomeMessage;
@GetMapping("/")
    public String helloworld()
    {
        return "<h1>"+welcomeMessage+"</h1>";
    }

}

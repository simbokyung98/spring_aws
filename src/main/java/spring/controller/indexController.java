package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.domain.UserEntity;
import spring.domain.UserRepository;

@Controller
@RequiredArgsConstructor
public class indexController {



    @GetMapping("/")
    public String index(){

        return "index";
    }
}

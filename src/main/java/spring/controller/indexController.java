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

    @GetMapping("/index")
    public String reindex(){

        return "index";
    }
    @GetMapping("/about")
    public String about(){

        return "index";
    }
    @GetMapping("/post")
    public String post(){

        return "post";
    }
    @GetMapping("/contact")
    public String contact(){

        return "contact";
    }
}

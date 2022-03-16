package com.fancybulbfinish.fancybulb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    

    @GetMapping("/")
    public String index(){


        return "home/index";
    }

    @GetMapping("Produtos-page")
    public String produtos(){

        
        return "home/Produtos";
    }

    @GetMapping("Sobre-page")
    public String sobre(){

        
        return "home/Sobre";
    }


    
}

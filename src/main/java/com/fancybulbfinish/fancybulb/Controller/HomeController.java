package com.fancybulbfinish.fancybulb.Controller;



import com.fancybulbfinish.fancybulb.Model.CadastroModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    


    @GetMapping("/")
    public String homeClientes(Model model, CadastroModel cad) {

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

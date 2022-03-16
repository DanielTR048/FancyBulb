package com.fancybulbfinish.fancybulb.Controller;

import com.fancybulbfinish.fancybulb.Model.CadastroModel;
import com.fancybulbfinish.fancybulb.Repository.fancybulbrepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private fancybulbrepo repo;

    @GetMapping("/Login-page")
    public String login(){

        return "login/Login";
    }

     @PostMapping("/logar")
    public String logar(Model model, CadastroModel cad){
        CadastroModel cada = this.repo.Login(cad.getEmail(), cad.getSenha());
        if (cada != null){
            return "redirect:/pos";
        }
        model.addAttribute("erro", "Usuario ou senha invalidos");
        return "login/Login";
    }
}

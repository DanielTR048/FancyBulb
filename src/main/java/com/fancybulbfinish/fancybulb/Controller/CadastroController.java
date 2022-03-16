package com.fancybulbfinish.fancybulb.Controller;

import java.util.List;

import com.fancybulbfinish.fancybulb.Model.CadastroModel;
import com.fancybulbfinish.fancybulb.Repository.fancybulbrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {
    
    @Autowired
    private fancybulbrepo repo;

    @GetMapping("/Lista-cadastro")
    public String listacad(Model model){
        List<CadastroModel> clientes = (List<CadastroModel>)repo.findAll();
        model.addAttribute("clientes", clientes);

        return "cadastro/lista";
    }
}

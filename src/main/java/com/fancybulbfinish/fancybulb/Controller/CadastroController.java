package com.fancybulbfinish.fancybulb.Controller;

import java.util.List;

import com.fancybulbfinish.fancybulb.Model.CadastroModel;
import com.fancybulbfinish.fancybulb.Repository.fancybulbrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {
    
    @Autowired
    private fancybulbrepo repo;

    @GetMapping("/Cadastro-cliente")
    public String cadnovo(){

        
        return "cadastro/novo";
    }

    @PostMapping("/cadastrar")
    public String criar(CadastroModel cadastroModel){
        repo.save(cadastroModel);
        return "redirect:/Login-page";
    }

    @GetMapping("/clientes/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/Lista-cadastro";
    }

    @GetMapping("/Lista-cadastro")
    public String listacad(Model model){
        List<CadastroModel> clientes = (List<CadastroModel>)repo.findAll();
        model.addAttribute("clientes", clientes);

        return "cadastro/lista";
    }


}

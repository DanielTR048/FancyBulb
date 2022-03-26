package com.fancybulbfinish.fancybulb.Controller;

import com.fancybulbfinish.fancybulb.Model.CadastroModel;
import com.fancybulbfinish.fancybulb.Model.CadastroModeladm;
import com.fancybulbfinish.fancybulb.Repository.fancybulbrepo;
import com.fancybulbfinish.fancybulb.Repository.fancybulbrepoadm;
import com.fancybulbfinish.fancybulb.service.CookieService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private fancybulbrepo repo;

    @Autowired
    private fancybulbrepoadm adm;

    @GetMapping("/Login-page")
    public String login() {

        return "login/Login";
    }

    @GetMapping("/Login-Admin")
    public String loginADM() {

        return "login/Login-adm";
    }

    @GetMapping("/ClienteLogar")
    public String loginCliente(Model model,  HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("NomeCliente", CookieService.getCookie(request, "NomeUsuario"));
        return "login/Cliente-login";
    }

    @PostMapping("/logar")
    public String logar(Model model, CadastroModel cad, String lembrar, HttpServletResponse response) throws IOException {
        CadastroModel cada = this.repo.Login(cad.getEmail(), cad.getSenha());
        if (cada != null) {

            int tempoLogado = (60 * 60); // 1 hour cookie
            if (lembrar != null)
                tempoLogado = (60 * 60 * 24 * 365); // 1 year cookie
            CookieService.setCookie(response, "usuariosId", String.valueOf(cada.getId()), tempoLogado);
            
            CookieService.setCookie(response, "NomeUsuario", String.valueOf(cada.getName()), tempoLogado);

            return "redirect:/ClienteLogar";
        }
        model.addAttribute("erro", "Usuario ou senha invalidos");
        return "login/Login";
    }

    @GetMapping("/exit")
    public String exit(HttpServletResponse response) throws IOException {

        CookieService.setCookie(response, "usuariosId","", 0);
        return "login/Login";
    }

    @PostMapping("/logar-adm")
    public String logarAdmin(Model model, CadastroModeladm cad,String lembrar, HttpServletResponse response) throws IOException {
        CadastroModeladm cadaADM = this.adm.Loginadm(cad.getEmail(), cad.getSenha());
        if (cadaADM != null) {

            int tempoLogado = (60 * 60); // 1 hour cookie
            if (lembrar != null)
                tempoLogado = (60 * 60 * 24 * 365); // 1 year cookie
            CookieService.setCookie(response, "usuariosId", String.valueOf(cadaADM.getId()), tempoLogado);

            return "redirect:/Lista-cadastro";
        }
        model.addAttribute("erro", "Usuario ou senha invalidos ");
        return "login/Login-adm";
    }

}

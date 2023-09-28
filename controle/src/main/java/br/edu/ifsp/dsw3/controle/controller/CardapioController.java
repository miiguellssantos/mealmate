package br.edu.ifsp.dsw3.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.controle.model.dao.CardapioDao;
import br.edu.ifsp.dsw3.controle.model.domain.Cardapio;

@Controller
@RequestMapping("/cardapios")
public class CardapioController {
    @Autowired
    CardapioDao dao;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/cardapio/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/cardapio/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cardapio cardapio) {
        dao.save(cardapio);
        return "redirect:/cardapio/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        dao.deleteById(id);
        return "redirect:/cardapio/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("cardapio", dao.findById(id).get());
        return "/cardapio/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cardapio cardapio) {
        dao.save(cardapio);
        return "redirect:/cardapio/listar";
    }
}
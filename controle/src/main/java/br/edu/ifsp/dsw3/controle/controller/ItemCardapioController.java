package br.edu.ifsp.dsw3.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.controle.model.dao.ItemCardapioDao;
import br.edu.ifsp.dsw3.controle.model.domain.ItemCardapio;

@Controller
@RequestMapping("/itens")
public class ItemCardapioController {
    @Autowired
    ItemCardapioDao dao;

    @GetMapping("/cadastrar")
    public String cadastrar(ItemCardapio itemCardapio) {
        return "/item/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("item", dao.findAll());
        return "/item/lista";
    }

    @PostMapping("/salvar")
    public String salvar(ItemCardapio itemCardapio) {
        dao.save(itemCardapio);
        return "redirect:/item/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        dao.deleteById(id);
        return "redirect:/item/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("item", dao.findById(id).get());
        return "/item/cadastro";
    }

    @PostMapping("/editar")
    public String editar(ItemCardapio itemCardapio) {
        dao.save(itemCardapio);
        return "redirect:/item/listar";
    }
}

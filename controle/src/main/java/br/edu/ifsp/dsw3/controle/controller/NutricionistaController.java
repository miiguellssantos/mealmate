package br.edu.ifsp.dsw3.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.controle.model.dao.NutricionistaDao;
import br.edu.ifsp.dsw3.controle.model.domain.Nutricionista;

@Controller
@RequestMapping("/nutricionistas")
public class NutricionistaController {
    @Autowired
    NutricionistaDao dao;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/nutricionista/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/nutricionista/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Nutricionista nutricionista) {
        dao.save(nutricionista);
        return "redirect:/nutricionista/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        dao.deleteById(id);
        return "redirect:/nutricionista/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("nutricionista", dao.findById(id).get());
        return "/nutricionista/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Nutricionista nutricionista) {
        dao.save(nutricionista);
        return "redirect:/nutricionista/listar";
    }
}
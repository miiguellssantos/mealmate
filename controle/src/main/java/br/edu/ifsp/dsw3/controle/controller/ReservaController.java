package br.edu.ifsp.dsw3.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.controle.model.dao.ReservaDao;
import br.edu.ifsp.dsw3.controle.model.domain.Reserva;

@Controller
@RequestMapping("/usuarios")
public class ReservaController {
    @Autowired
    ReservaDao dao;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/reserva/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/reserva/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Reserva reserva) {
        dao.save(reserva);
        return "redirect:/reserva/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        dao.deleteById(id);
        return "redirect:/reserva/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("reserva", dao.findById(id).get());
        return "/reserva/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Reserva reserva) {
        dao.save(reserva);
        return "redirect:/reserva/listar";
    }
}
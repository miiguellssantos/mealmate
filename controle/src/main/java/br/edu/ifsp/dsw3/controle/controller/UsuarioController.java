package br.edu.ifsp.dsw3.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.controle.model.dao.UsuarioDao;
import br.edu.ifsp.dsw3.controle.model.domain.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioDao dao;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/usuario/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "/usuario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario) {
        dao.save(usuario);
        return "redirect:/usuario/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        dao.deleteById(id);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("usuario", dao.findById(id).get());
        return "/usuario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Usuario usuario) {
        dao.save(usuario);
        return "redirect:/usuario/listar";
    }
}

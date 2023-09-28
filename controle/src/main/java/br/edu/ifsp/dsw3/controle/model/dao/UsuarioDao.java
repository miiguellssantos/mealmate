package br.edu.ifsp.dsw3.controle.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.controle.model.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}

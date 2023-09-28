package br.edu.ifsp.dsw3.controle.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.controle.model.domain.Retirada;

public interface RetiradaDao extends JpaRepository<Retirada, Long> {

}

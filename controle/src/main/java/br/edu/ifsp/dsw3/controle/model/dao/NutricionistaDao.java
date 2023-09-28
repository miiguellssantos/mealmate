package br.edu.ifsp.dsw3.controle.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.controle.model.domain.Nutricionista;

public interface NutricionistaDao extends JpaRepository<Nutricionista, Long> {

}

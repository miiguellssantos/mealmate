package br.edu.ifsp.dsw3.controle.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "nutricionistas")
public class Nutricionista extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @Column(name = "especializacao", nullable = false, length = 100)
    private String especializacao;

    public Nutricionista(String nome, String especializacao) {
        this.nome = nome;
        this.especializacao = especializacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return "Nutricionista [nome=" + nome + ", especializacao=" + especializacao + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((especializacao == null) ? 0 : especializacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nutricionista other = (Nutricionista) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (especializacao == null) {
            if (other.especializacao != null)
                return false;
        } else if (!especializacao.equals(other.especializacao))
            return false;
        return true;
    }
}

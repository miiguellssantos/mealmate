package br.edu.ifsp.dsw3.controle.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "prontuario", nullable = false, unique = true, length = 15)
    private String prontuario;

    @Column(name = "curso", length = 100)
    private String curso;

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    public Usuario(String nome, String curso, String prontuario, String senha) {
        this.nome = nome;
        this.curso = curso;
        this.prontuario = prontuario;
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", curso=" + curso + ", prontuario=" + prontuario + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((prontuario == null) ? 0 : prontuario.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
        Usuario other = (Usuario) obj;
        if (curso == null) {
            if (other.curso != null)
                return false;
        } else if (!curso.equals(other.curso))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (prontuario == null) {
            if (other.prontuario != null)
                return false;
        } else if (!prontuario.equals(other.prontuario))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }
}

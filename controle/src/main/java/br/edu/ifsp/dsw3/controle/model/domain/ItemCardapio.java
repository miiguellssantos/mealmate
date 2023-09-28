package br.edu.ifsp.dsw3.controle.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens")
public class ItemCardapio extends AbstractEntity<Long> {

    @Column(name = "descricao", nullable = false, unique = true, length = 100)
    private String descricao;

    @Column(name = "grupoNutricional", nullable = false, unique = true, length = 150)
    private String grupoNutricional;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupoNutricional() {
        return grupoNutricional;
    }

    public void setGrupoNutricional(String grupoNutricional) {
        this.grupoNutricional = grupoNutricional;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((grupoNutricional == null) ? 0 : grupoNutricional.hashCode());
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
        ItemCardapio other = (ItemCardapio) obj;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (grupoNutricional == null) {
            if (other.grupoNutricional != null)
                return false;
        } else if (!grupoNutricional.equals(other.grupoNutricional))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ItemCardapio [descricao=" + descricao + ", grupoNutricional=" + grupoNutricional + "]";
    }

}

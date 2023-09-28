package br.edu.ifsp.dsw3.controle.model.domain;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cardapios")
public class Cardapio extends AbstractEntity<Long> {

    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false, name = "data_criacao", columnDefinition = "DATE")
    private LocalDate data_criacao;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "data_validade", columnDefinition = "DATE")
    private LocalDate data_validade;

    @ManyToOne
    @JoinColumn(name = "itemCardapio_id_fk")
    private ItemCardapio itemCardapio;

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
        result = prime * result + ((data_validade == null) ? 0 : data_validade.hashCode());
        result = prime * result + ((itemCardapio == null) ? 0 : itemCardapio.hashCode());
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
        Cardapio other = (Cardapio) obj;
        if (data_criacao == null) {
            if (other.data_criacao != null)
                return false;
        } else if (!data_criacao.equals(other.data_criacao))
            return false;
        if (data_validade == null) {
            if (other.data_validade != null)
                return false;
        } else if (!data_validade.equals(other.data_validade))
            return false;
        if (itemCardapio == null) {
            if (other.itemCardapio != null)
                return false;
        } else if (!itemCardapio.equals(other.itemCardapio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cardapio [data_criacao=" + data_criacao + ", data_validade=" + data_validade + ", itemCardapio="
                + itemCardapio + "]";
    }
}

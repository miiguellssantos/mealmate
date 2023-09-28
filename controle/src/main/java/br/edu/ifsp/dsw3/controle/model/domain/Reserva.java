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
@Table(name = "reserva")
public class Reserva extends AbstractEntity<Long> {

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "data_pedido", columnDefinition = "DATE")
    private LocalDate DataPedido;

    @ManyToOne
    @JoinColumn(name = "itemCardapio_id_fk")
    private ItemCardapio itemCardapio;

    @Column(name = "prontuario", nullable = false, unique = true, length = 150)
    private String prontuario;

    public LocalDate getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        DataPedido = dataPedido;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((DataPedido == null) ? 0 : DataPedido.hashCode());
        result = prime * result + ((itemCardapio == null) ? 0 : itemCardapio.hashCode());
        result = prime * result + ((prontuario == null) ? 0 : prontuario.hashCode());
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
        Reserva other = (Reserva) obj;
        if (DataPedido == null) {
            if (other.DataPedido != null)
                return false;
        } else if (!DataPedido.equals(other.DataPedido))
            return false;
        if (itemCardapio == null) {
            if (other.itemCardapio != null)
                return false;
        } else if (!itemCardapio.equals(other.itemCardapio))
            return false;
        if (prontuario == null) {
            if (other.prontuario != null)
                return false;
        } else if (!prontuario.equals(other.prontuario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reserva [DataPedido=" + DataPedido + ", itemCardapio=" + itemCardapio + ", prontuario=" + prontuario
                + "]";
    }

}

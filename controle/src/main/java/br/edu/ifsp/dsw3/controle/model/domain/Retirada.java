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
@Table(name = "retirada")
public class Retirada extends AbstractEntity<Long> {

    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false, name = "data_retirada", columnDefinition = "DATE")
    private LocalDate dataRetirada;

    @DateTimeFormat(iso = ISO.TIME)
    @Column(nullable = false, name = "hora_retirada", columnDefinition = "TIME")
    private LocalDate horaRetirada;

    @ManyToOne
    @JoinColumn(name = "Reserva_id_fk")
    private ItemCardapio Reserva;

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(LocalDate horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public ItemCardapio getReserva() {
        return Reserva;
    }

    public void setReserva(ItemCardapio reserva) {
        Reserva = reserva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
        result = prime * result + ((horaRetirada == null) ? 0 : horaRetirada.hashCode());
        result = prime * result + ((Reserva == null) ? 0 : Reserva.hashCode());
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
        Retirada other = (Retirada) obj;
        if (dataRetirada == null) {
            if (other.dataRetirada != null)
                return false;
        } else if (!dataRetirada.equals(other.dataRetirada))
            return false;
        if (horaRetirada == null) {
            if (other.horaRetirada != null)
                return false;
        } else if (!horaRetirada.equals(other.horaRetirada))
            return false;
        if (Reserva == null) {
            if (other.Reserva != null)
                return false;
        } else if (!Reserva.equals(other.Reserva))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Retirada [dataRetirada=" + dataRetirada + ", horaRetirada=" + horaRetirada + ", Reserva=" + Reserva
                + "]";
    }

}

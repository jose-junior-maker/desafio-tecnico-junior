package com.jose.posto.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_abastecimento")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataAbastecimento;

    private BigDecimal litragem;

    @ManyToOne
    @JoinColumn(name = "bomba_id")
    private Bomba bomba;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(LocalDateTime dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public BigDecimal getLitragem() {
        return litragem;
    }

    public void setLitragem(BigDecimal litragem) {
        this.litragem = litragem;
    }

    public Bomba getBomba() {
        return bomba;
    }

    public void setBomba(Bomba bomba) {
        this.bomba = bomba;
    }

    public BigDecimal valorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;

        if (bomba != null) {
            valorTotal =  bomba.getCombustivel().getPrecoPorLitro().multiply(litragem);
        }

        return valorTotal;
    }
}

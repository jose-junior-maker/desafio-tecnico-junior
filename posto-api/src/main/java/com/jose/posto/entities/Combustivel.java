package com.jose.posto.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_combustivel")
public class Combustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCombustivel;
    private BigDecimal precoPorLitro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoPorLitro() {
        return precoPorLitro;
    }

    public void setPrecoPorLitro(BigDecimal precoPorLitro) {
        this.precoPorLitro = precoPorLitro;
    }
}

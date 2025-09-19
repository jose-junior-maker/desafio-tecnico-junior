package com.jose.posto.dto;

import com.jose.posto.entities.Combustivel;

import java.math.BigDecimal;

public class CombustivelDTO {

    private Long id;
    private String nomeCombustivel;
    private BigDecimal precoPorLitro;

    public CombustivelDTO() {}

    public CombustivelDTO(Combustivel combustivel) {
        this.id = combustivel.getId();
        this.nomeCombustivel = combustivel.getNomeCombustivel();
        this.precoPorLitro = combustivel.getPrecoPorLitro();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }

    public BigDecimal getPrecoPorLitro() {
        return precoPorLitro;
    }

    public void setPrecoPorLitro(BigDecimal precoPorLitro) {
        this.precoPorLitro = precoPorLitro;
    }
}

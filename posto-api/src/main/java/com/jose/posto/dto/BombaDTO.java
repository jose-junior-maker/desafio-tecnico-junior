package com.jose.posto.dto;

import com.jose.posto.entities.Bomba;

public class BombaDTO {

    private Long id;
    private String nomeBomba;
    private CombustivelDTO combustivel;

    public BombaDTO() {}

    public BombaDTO(Bomba bomba) {
        this.id = bomba.getId();
        this.nomeBomba = bomba.getNomeBomba();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeBomba() {
        return nomeBomba;
    }

    public void setNomeBomba(String nomeBomba) {
        this.nomeBomba = nomeBomba;
    }

    public CombustivelDTO getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(CombustivelDTO combustivel) {
        this.combustivel = combustivel;
    }
}

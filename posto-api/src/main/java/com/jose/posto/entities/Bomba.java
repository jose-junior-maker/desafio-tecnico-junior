package com.jose.posto.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_bomba")
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeBomba;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private Combustivel combustivel;

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

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
}

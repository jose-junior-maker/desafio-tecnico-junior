package com.jose.posto.dto;

import com.jose.posto.entities.Abastecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AbastecimentoDTO {

    private Long id;
    private BigDecimal litragem;
    private LocalDateTime dataAbastecimento;
    private BigDecimal valorAbastecimento;
    private BombaDTO bomba;

    public AbastecimentoDTO() {}

    public AbastecimentoDTO(Abastecimento abastecimento) {
        this.id = abastecimento.getId();
        this.litragem = abastecimento.getLitragem();
        this.dataAbastecimento = abastecimento.getDataAbastecimento();
        this.valorAbastecimento = abastecimento.valorTotal();
        this.bomba = new BombaDTO(abastecimento.getBomba());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getLitragem() {
        return litragem;
    }

    public void setLitragem(BigDecimal litragem) {
        this.litragem = litragem;
    }

    public BombaDTO getBomba() {
        return bomba;
    }

    public void setBomba(BombaDTO bomba) {
        this.bomba = bomba;
    }

    public LocalDateTime getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(LocalDateTime dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public BigDecimal getValorAbastecimento() {
        return valorAbastecimento;
    }
}

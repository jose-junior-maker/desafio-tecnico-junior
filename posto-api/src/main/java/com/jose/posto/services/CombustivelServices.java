package com.jose.posto.services;

import com.jose.posto.dto.CombustivelDTO;
import com.jose.posto.entities.Combustivel;
import com.jose.posto.repositories.CombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombustivelServices {

    @Autowired
    private CombustivelRepository combustivelRepository;

    @Transactional
    public CombustivelDTO create(CombustivelDTO combustivelDTO) {

        Combustivel combustivel = new Combustivel();
        combustivel.setNomeCombustivel(combustivelDTO.getNomeCombustivel());
        combustivel.setPrecoPorLitro(combustivelDTO.getPrecoPorLitro());

        combustivel = combustivelRepository.save(combustivel);

        return new CombustivelDTO(combustivel);
    }

    @Transactional(readOnly = true)
    public List<CombustivelDTO> list(){

        List<Combustivel> combustiveis = combustivelRepository.findAll();
        List<CombustivelDTO> combustiveisDTO = new ArrayList<>();
        combustiveis.forEach(combustivel -> {
            combustiveisDTO.add(new CombustivelDTO(combustivel));
        });

        return combustiveisDTO;
    }

    @Transactional
    public CombustivelDTO update(CombustivelDTO combustivelDTO){

        Combustivel combustivel = combustivelRepository.findById(combustivelDTO.getId()).get();
        combustivel.setNomeCombustivel(combustivelDTO.getNomeCombustivel());
        combustivel.setPrecoPorLitro(combustivelDTO.getPrecoPorLitro());
        combustivel = combustivelRepository.save(combustivel);

        return new CombustivelDTO(combustivel);
    }

    @Transactional
    public CombustivelDTO delete(CombustivelDTO combustivelDTO){

        Combustivel combustivel = combustivelRepository.findById(combustivelDTO.getId()).get();
        combustivelRepository.delete(combustivel);

        return new CombustivelDTO(combustivel);
    }
}

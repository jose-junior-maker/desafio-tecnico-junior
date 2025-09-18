package com.jose.posto.services;

import com.jose.posto.dto.CombustivelDTO;
import com.jose.posto.entities.Combustivel;
import com.jose.posto.repositories.CombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombustivelServices {

    @Autowired
    private CombustivelRepository combustivelRepository;

    public CombustivelDTO create(CombustivelDTO combustivelDTO) {
        return null;
    }

    public List<CombustivelDTO> list(){

        List<Combustivel> combustiveis = combustivelRepository.findAll();
        List<CombustivelDTO> combustiveisDTO = new ArrayList<>();
        combustiveis.forEach(combustivel -> {
            combustiveisDTO.add(new CombustivelDTO());
        });

        return combustiveisDTO;
    }

    public CombustivelDTO update(CombustivelDTO combustivelDTO){
        return null;
    }

    public CombustivelDTO delete(CombustivelDTO combustivelDTO){
        return null;
    }
}

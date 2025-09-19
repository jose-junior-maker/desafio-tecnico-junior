package com.jose.posto.services;

import com.jose.posto.dto.BombaDTO;
import com.jose.posto.dto.CombustivelDTO;
import com.jose.posto.entities.Bomba;
import com.jose.posto.entities.Combustivel;
import com.jose.posto.repositories.BombaRepository;
import com.jose.posto.repositories.CombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BombaServices {

    @Autowired
    private BombaRepository bombaRepository;

    @Autowired
    private CombustivelRepository combustivelRepository;

    @Transactional
    public BombaDTO create(BombaDTO bombaDTO) {

        Bomba bomba = new Bomba();
        bomba.setNomeBomba(bombaDTO.getNomeBomba());
        Combustivel combustivel = combustivelRepository.getReferenceById(bombaDTO.getCombustivel().getId());
        bomba.setCombustivel(combustivel);

        bomba = bombaRepository.save(bomba);

        return new BombaDTO(bomba);

    }

    @Transactional(readOnly = true)
    public List<BombaDTO> list(){

        List<Bomba> bombas = bombaRepository.findAll();
        List<BombaDTO> bombasDTO = new ArrayList<>();
        bombas.forEach(b -> bombasDTO.add(new BombaDTO(b)));

        return bombasDTO;
    }

    @Transactional
    public BombaDTO update(BombaDTO bombaDTO){

        Bomba bomba = bombaRepository.getReferenceById(bombaDTO.getId());
        bomba.setNomeBomba(bombaDTO.getNomeBomba());
        Combustivel combustivel = combustivelRepository.getReferenceById(bombaDTO.getCombustivel().getId());
        bomba.setCombustivel(combustivel);
        bomba = bombaRepository.save(bomba);
        return new BombaDTO(bomba);
    }

    @Transactional
    public BombaDTO delete(BombaDTO bombaDTO){
        Bomba bomba = bombaRepository.getReferenceById(bombaDTO.getId());
        bombaRepository.delete(bomba);

        return new BombaDTO(bomba);
    }
}

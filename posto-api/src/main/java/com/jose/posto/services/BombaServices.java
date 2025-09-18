package com.jose.posto.services;

import com.jose.posto.dto.BombaDTO;
import com.jose.posto.dto.CombustivelDTO;
import com.jose.posto.entities.Bomba;
import com.jose.posto.repositories.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BombaServices {

    @Autowired
    private BombaRepository bombaRepository;

    public BombaDTO create(BombaDTO bombaDTO) {
        return null;
    }

    public List<BombaDTO> list(){

        List<Bomba> bombas = bombaRepository.findAll();
        List<BombaDTO> bombasDTO = new ArrayList<>();
        bombas.forEach(b -> bombasDTO.add(new BombaDTO(b)));

        return bombasDTO;
    }

    public BombaDTO update(BombaDTO bombaDTO){
        return null;
    }

    public BombaDTO delete(BombaDTO bombaDTO){
        return null;
    }
}

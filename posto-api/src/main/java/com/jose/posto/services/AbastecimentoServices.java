package com.jose.posto.services;

import com.jose.posto.dto.AbastecimentoDTO;
import com.jose.posto.dto.BombaDTO;
import com.jose.posto.entities.Abastecimento;
import com.jose.posto.entities.Bomba;
import com.jose.posto.repositories.AbastecimentoRepository;
import com.jose.posto.repositories.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbastecimentoServices {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private BombaRepository bombaRepository;

    public AbastecimentoDTO create(AbastecimentoDTO abastecimentoDTO) {

        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setLitragem(abastecimentoDTO.getLitragem());
        Bomba bomba = bombaRepository.getReferenceById(abastecimentoDTO.getBomba().getId());
        abastecimento.setBomba(bomba);

        abastecimento = abastecimentoRepository.save(abastecimento);

        return new AbastecimentoDTO(abastecimento);
    }

    public List<AbastecimentoDTO> list(){

        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll();
        List<AbastecimentoDTO> abastecimentosDTO = new ArrayList<>();
        abastecimentos.forEach(abastecimento -> {
            abastecimentosDTO.add(new AbastecimentoDTO(abastecimento));
        });

        return abastecimentosDTO;
    }

    public AbastecimentoDTO update(AbastecimentoDTO abastecimentoDTO){
        return null;
    }

    public AbastecimentoDTO delete(AbastecimentoDTO abastecimentoDTO){
        return null;
    }
}

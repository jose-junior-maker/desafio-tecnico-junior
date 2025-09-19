package com.jose.posto.services;

import com.jose.posto.dto.AbastecimentoDTO;
import com.jose.posto.dto.BombaDTO;
import com.jose.posto.entities.Abastecimento;
import com.jose.posto.entities.Bomba;
import com.jose.posto.entities.Combustivel;
import com.jose.posto.repositories.AbastecimentoRepository;
import com.jose.posto.repositories.BombaRepository;
import com.jose.posto.repositories.CombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbastecimentoServices {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private BombaRepository bombaRepository;

    @Autowired
    private CombustivelRepository combustivelRepository;

    @Transactional
    public AbastecimentoDTO create(AbastecimentoDTO abastecimentoDTO) {

        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setLitragem(abastecimentoDTO.getLitragem());
        Bomba bomba = bombaRepository.getReferenceById(abastecimentoDTO.getBomba().getId());
        abastecimento.setBomba(bomba);

        abastecimento = abastecimentoRepository.save(abastecimento);

        return new AbastecimentoDTO(abastecimento);
    }

    @Transactional(readOnly = true)
    public List<AbastecimentoDTO> list(){

        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll();
        List<AbastecimentoDTO> abastecimentosDTO = new ArrayList<>();
        abastecimentos.forEach(abastecimento -> {
            abastecimentosDTO.add(new AbastecimentoDTO(abastecimento));
        });

        return abastecimentosDTO;
    }

    @Transactional
    public AbastecimentoDTO update(AbastecimentoDTO abastecimentoDTO){

//        Combustivel combustivel = combustivelRepository.getReferenceById(combustivel.getId());
//        combustivel.set
//        Bomba bomba = bombaRepository.findById(abastecimentoDTO.getBomba().getId()).get();
//        bomba.setNomeBomba(abastecimentoDTO.getBomba().getNomeBomba());
        Abastecimento abastecimento = abastecimentoRepository.findById(abastecimentoDTO.getId()).get();
        abastecimento.setLitragem(abastecimentoDTO.getLitragem());
        abastecimento.setDataAbastecimento(abastecimentoDTO.getDataAbastecimento());
        abastecimento = abastecimentoRepository.save(abastecimento);
        return new AbastecimentoDTO(abastecimento);

    }

    @Transactional
    public AbastecimentoDTO delete(AbastecimentoDTO abastecimentoDTO){

        Abastecimento abastecimento = abastecimentoRepository.findById(abastecimentoDTO.getId()).get();
        abastecimentoRepository.delete(abastecimento);

        return new AbastecimentoDTO(abastecimento);
    }
}

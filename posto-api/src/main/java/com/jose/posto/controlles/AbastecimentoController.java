package com.jose.posto.controlles;

import com.jose.posto.dto.AbastecimentoDTO;
import com.jose.posto.services.AbastecimentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoServices abastecimentoServices;

    @PostMapping
    public ResponseEntity<AbastecimentoDTO> criaAbastecimento(AbastecimentoDTO abastecimento) {
        return ResponseEntity.ok().body(abastecimentoServices.create(abastecimento));
    }
}

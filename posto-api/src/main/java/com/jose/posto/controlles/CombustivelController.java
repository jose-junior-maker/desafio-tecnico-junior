package com.jose.posto.controlles;

import com.jose.posto.dto.CombustivelDTO;
import com.jose.posto.services.CombustivelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {

    @Autowired
    private CombustivelServices combustivelServices;

    @PostMapping
    public ResponseEntity<CombustivelDTO> criaCombustivel(@RequestBody CombustivelDTO combustivelDTO){
        return ResponseEntity.ok().body(combustivelServices.create(combustivelDTO));
    }

    @GetMapping
    public ResponseEntity<List<CombustivelDTO>> listarCombustiveis(){
        return ResponseEntity.ok().body(combustivelServices.list());
    }

    @PutMapping
    public ResponseEntity<CombustivelDTO> alteraCombustivel(@RequestBody CombustivelDTO combustivelDTO){
        return ResponseEntity.ok().body(combustivelServices.update(combustivelDTO));
    }

    @DeleteMapping
    public ResponseEntity<CombustivelDTO> deletarCombustivel(@RequestBody CombustivelDTO combustivelDTO){
        return ResponseEntity.ok().body(combustivelServices.delete(combustivelDTO));
    }
}

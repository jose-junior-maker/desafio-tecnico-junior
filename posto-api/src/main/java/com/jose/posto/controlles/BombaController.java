package com.jose.posto.controlles;

import com.jose.posto.dto.BombaDTO;
import com.jose.posto.services.BombaServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bomba")
public class BombaController {

    @Autowired
    private BombaServices bombaServices;

    @PostMapping
    public ResponseEntity<BombaDTO> criarBomba(@RequestBody BombaDTO bombaDTO) {
        return ResponseEntity.ok().body(bombaServices.create(bombaDTO));
    }

    @GetMapping
    public ResponseEntity<List<BombaDTO>> listarBomba() {
        return ResponseEntity.ok().body(bombaServices.list());
    }

    @PutMapping
    public ResponseEntity<BombaDTO> atualizarBomba(@RequestBody BombaDTO bombaDTO) {
        return ResponseEntity.ok().body(bombaServices.update(bombaDTO));
    }

    @DeleteMapping
    public ResponseEntity<BombaDTO> removerBomba(@RequestBody BombaDTO bombaDTO) {
        return ResponseEntity.ok().body(bombaServices.delete(bombaDTO));
    }
}

package com.lucasvm.cep_api.controllers;

import com.lucasvm.cep_api.dtos.EnderecoResponseDto;
import com.lucasvm.cep_api.services.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponseDto> getCep(@PathVariable String cep) {

        var cepDto = cepService.buscarCep(cep);
        return ResponseEntity.ok(cepDto);

    }


}

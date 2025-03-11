package com.lucasvm.user_api.controllers;

import com.lucasvm.user_api.dtos.UsuarioRequestDto;
import com.lucasvm.user_api.dtos.UsuarioResponseDto;
import com.lucasvm.user_api.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> postUsuario(@RequestBody UsuarioRequestDto requestDto) {

        return usuarioService.postUsuario(requestDto);

    }


}

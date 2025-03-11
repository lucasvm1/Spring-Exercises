package com.lucasvm.user_api.services;

import com.lucasvm.user_api.dtos.UsuarioRequestDto;
import com.lucasvm.user_api.dtos.UsuarioResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);


    public ResponseEntity<UsuarioResponseDto> postUsuario(UsuarioRequestDto requestDto) {

        RestTemplate restTemplate = new RestTemplate();

        var request = new UsuarioRequestDto(requestDto.getNome(), requestDto.getCargo());

        try {

            var response = restTemplate.postForEntity("https://reqres.in/api/users/", request, UsuarioResponseDto.class);
            return response;

        } catch (HttpClientErrorException e) {
            LOGGER.error("Erro ao enviar os dados do API:", e);
            throw new HttpClientErrorException(e.getStatusCode(), e.getResponseBodyAsString());
        }


    }


}

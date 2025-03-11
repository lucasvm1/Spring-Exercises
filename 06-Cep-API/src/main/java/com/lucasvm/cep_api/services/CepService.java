package com.lucasvm.cep_api.services;

import com.lucasvm.cep_api.dtos.EnderecoResponseDto;
import com.lucasvm.cep_api.exceptions.CepNaoEncontradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CepService.class);

    public EnderecoResponseDto buscarCep(String cep) {
        String url = ("https://viacep.com.br/ws/" + cep + "/json/");

        RestTemplate restTemplate = new RestTemplate();

        try {
            var response = restTemplate.getForObject(url, EnderecoResponseDto.class);

            if (response == null || response.getCep() == null) {
                throw new CepNaoEncontradoException("CEP not found: " + cep);
            }

            return response;

        } catch (HttpClientErrorException e) {
            LOGGER.error("An error occured while trying to retrieve cep:", e);
            throw new CepNaoEncontradoException(cep);
        }


    }


}

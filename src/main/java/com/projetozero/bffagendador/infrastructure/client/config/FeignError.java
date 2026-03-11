package com.projetozero.bffagendador.infrastructure.client.config;


import com.projetozero.bffagendador.infrastructure.exception.BusinessException;
import com.projetozero.bffagendador.infrastructure.exception.ConflictException;
import com.projetozero.bffagendador.infrastructure.exception.ResourceNotFoundException;
import com.projetozero.bffagendador.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    private static final String PREFIXO_ERRO = "Erro: ";

    @Override
    public Exception decode(String s, Response response) {

        String mensagemErro = mensagemErro(response);

        switch (response.status()) {
            case 409:
                return new ConflictException(PREFIXO_ERRO + mensagemErro);
            case 403:
                return new ResourceNotFoundException(PREFIXO_ERRO + mensagemErro);
            case 401:
                return new UnauthorizedException(PREFIXO_ERRO + mensagemErro);
            case 400:
                return new IllegalArgumentException(PREFIXO_ERRO + mensagemErro);
            default:
                return new BusinessException(PREFIXO_ERRO + mensagemErro);
        }
    }

    private String mensagemErro(Response response){
        try {
            if(Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
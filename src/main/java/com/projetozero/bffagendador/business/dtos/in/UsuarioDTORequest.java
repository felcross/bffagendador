package com.projetozero.bffagendador.business.dtos.in;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResquest> enderecos;
    private List<TelefoneDTORequest> telefones;
}

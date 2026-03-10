package com.projetozero.bffagendador.business.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTORequest {


    private String numero;
    private String ddd;
}

package com.projetozero.bffagendador.business.dtos.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResponse {

    private Long id;
    private String numero;
    private String ddd;
}

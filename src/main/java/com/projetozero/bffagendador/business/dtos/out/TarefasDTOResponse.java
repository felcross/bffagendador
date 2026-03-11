package com.projetozero.bffagendador.business.dtos.out;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.projetozero.bffagendador.business.enums.StatusTarefaEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class TarefasDTOResponse {
    private String id;
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataAgendamento;
    private String emailUsuario;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataAlteracao;
    private StatusTarefaEnum status;
}

package com.projetozero.bffagendador.infrastructure.client;


import com.projetozero.bffagendador.business.dtos.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefasDTOResponse dto);

}

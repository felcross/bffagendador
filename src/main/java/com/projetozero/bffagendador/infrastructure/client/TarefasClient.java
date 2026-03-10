package com.projetozero.bffagendador.infrastructure.client;

import com.projetozero.bffagendador.business.dtos.in.TarefasDTORequest;
import com.projetozero.bffagendador.business.dtos.out.TarefasDTOResponse;
import com.projetozero.bffagendador.business.enums.StatusTarefaEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader(value = "Authorization", required=false) String token );


    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(value = "Authorization", required=false) String token);

    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader(value = "Authorization", required=false) String token );


    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader(value = "Authorization", required=false) String token );


    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusTarefaEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader(value = "Authorization", required=false) String token );


    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader(value = "Authorization", required=false) String token );


}

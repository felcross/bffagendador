package com.projetozero.bffagendador.business;



import com.projetozero.bffagendador.business.dtos.out.TarefasDTOResponse;
import com.projetozero.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviarEmail(TarefasDTOResponse dto) {
         emailClient.enviarEmail(dto);

    }

}

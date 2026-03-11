package com.projetozero.bffagendador.business;


import com.projetozero.bffagendador.business.dtos.in.LoginRequestDTO;
import com.projetozero.bffagendador.business.dtos.out.TarefasDTOResponse;
import com.projetozero.bffagendador.business.enums.StatusTarefaEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora(){
        String token = "Bearer " + login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaAtual = LocalDateTime.now(); //LocalDateTime.now (hora atual) plus
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        //Qualquer tarefa que fique entre hora atual - e a hora futura + 1
        // Se agora é 22h - qualquer tarefa entre 22h e 23h
        // Se agora é 22h - qualquer tarefa entre 23h e 23h05 -- antes

        List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(horaAtual, horaFutura, token);
        log.info("Tarefas encontradas {}", listaTarefas);
        listaTarefas.forEach(tarefa -> {
            emailService.enviarEmail(tarefa);
            log.info("Email enviado para o usuario " + tarefa.getEmailUsuario());
            tarefasService.alteraStatus(StatusTarefaEnum.NOTIFICADO, tarefa.getId(),
                    token);
        });
        log.info("Finalizada a busca e notificação de tarefas");
    }

    public LoginRequestDTO converterParaRequestDTO(){
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }

    public String login(LoginRequestDTO loginRequestDTO) {
        return usuarioService.loginUsuario(loginRequestDTO);
  }


}

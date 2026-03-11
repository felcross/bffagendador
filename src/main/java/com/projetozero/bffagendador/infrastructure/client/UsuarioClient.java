package com.projetozero.bffagendador.infrastructure.client;



import com.projetozero.bffagendador.business.dtos.in.EnderecoDTOResquest;
import com.projetozero.bffagendador.business.dtos.in.LoginRequestDTO;
import com.projetozero.bffagendador.business.dtos.in.TelefoneDTORequest;
import com.projetozero.bffagendador.business.dtos.in.UsuarioDTORequest;
import com.projetozero.bffagendador.business.dtos.out.EnderecoDTOResponse;
import com.projetozero.bffagendador.business.dtos.out.TelefoneDTOResponse;
import com.projetozero.bffagendador.business.dtos.out.UsuarioDTOResponse;
import com.projetozero.bffagendador.business.dtos.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required=false) String token );

    @PatchMapping
    UsuarioDTOResponse atualizDadoUsuario(@RequestBody UsuarioDTORequest dto,
                                          @RequestHeader(value = "Authorization", required=false) String token );

    @PatchMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTOResquest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @PatchMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastaEndereco(@RequestBody EnderecoDTOResquest dto,
                                        @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);
}
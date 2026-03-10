package com.projetozero.bffagendador.business;



import com.projetozero.bffagendador.business.dtos.in.EnderecoDTOResquest;
import com.projetozero.bffagendador.business.dtos.in.LoginRequestDTO;
import com.projetozero.bffagendador.business.dtos.in.TelefoneDTORequest;
import com.projetozero.bffagendador.business.dtos.in.UsuarioDTORequest;
import com.projetozero.bffagendador.business.dtos.out.EnderecoDTOResponse;
import com.projetozero.bffagendador.business.dtos.out.TelefoneDTOResponse;
import com.projetozero.bffagendador.business.dtos.out.UsuarioDTOResponse;
import com.projetozero.bffagendador.business.dtos.out.ViaCepDTOResponse;
import com.projetozero.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;


    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto) {
        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }


    public void deletaUsuarioPorEmail(String email, String token) {

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizDadoUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTOResquest enderecoDTO,
                                                String token) {

        return client.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {

        return client.atualizaTelefone(dto, idTelefone, token);

    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTOResquest dto) {

        return client.cadastaEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {

        return client.cadastraTelefone(dto, token);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep(String cep) {
        return client.buscarDadosCep(cep);
    }

}

package br.com.ifpe.oxefood.modelo.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnderecoClienteService {
    @Autowired
    private EnderecoClienteRepository enderecoRepository;

    public EnderecoCliente save(EnderecoCliente endereco) {

        endereco.setHabilitado(Boolean.TRUE);
        endereco.setVersao(1L);
        endereco.setDataCriacao(LocalDate.now());
        return enderecoRepository.save(endereco);

    }

    public List<EnderecoCliente> listarTodos() {

        return enderecoRepository.findAll();
    }

    public EnderecoCliente obterPorID(Long id) {

        return enderecoRepository.findById(id).get();
    }

    public void update(long id, EnderecoCliente enderecoAlterado){

        EnderecoCliente endereco = enderecoRepository.findById(id).get();
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setComplemento(enderecoAlterado.getComplemento());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setEstado(enderecoAlterado.getEstado());
        enderecoRepository.save(endereco);
    }

    public void delete(Long id) {

        EnderecoCliente endereco = enderecoRepository.findById(id).get();
        endereco.setHabilitado(Boolean.FALSE);
        endereco.setVersao(endereco.getVersao() + 1);

        enderecoRepository.save(endereco);
    }
}

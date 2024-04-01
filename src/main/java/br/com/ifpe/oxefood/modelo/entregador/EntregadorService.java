package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        entregador.setVersao(1L);
        entregador.setDataCriacao(LocalDate.now());
        return repository.save(entregador);
    }
    public List<Entregador> listarTodos() {

    return repository.findAll();
    }

    public Entregador obterPorID(Long id) {

    return repository.findById(id).get();
    }
    @Transactional
    public void update(long id, Entregador entregadorAlterado){

        Entregador entregador = repository.findById(id).get();
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setVersao(entregador.getVersao() + 1);
        entregador.setNome(entregador.getNome());
        entregador.setCpf(entregador.getCpf());
        entregador.setRg(entregador.getRg());
        entregador.setDataNascimento(entregador.getDataNascimento());
        entregador.setFoneCelular(entregador.getFoneCelular());
        entregador.setFoneFixo(entregador.getFoneFixo());
        entregador.setQtdEntregasRealizadas(entregador.getQtdEntregasRealizadas());
        repository.save(entregador);
    }
}
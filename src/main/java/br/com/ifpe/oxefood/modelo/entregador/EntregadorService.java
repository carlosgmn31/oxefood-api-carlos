package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        entregador.setVersao(1L);
        entregador.setDataCriacao(LocalDate.now());
        return entregadorRepository.save(entregador);
    }
    public List<Entregador> listarTodos() {

    return entregadorRepository.findAll();
    }

    public Entregador obterPorID(Long id) {

    return entregadorRepository.findById(id).get();
    }
    @Transactional
    public void update(long id, Entregador entregadorAlterado){

        Entregador entregador = entregadorRepository.findById(id).get();
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setAtivo(entregadorAlterado.getAtivo());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setVersao(entregador.getVersao() + 1);
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setRg(entregadorAlterado.getRg());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
        entregadorRepository.save(entregador);
    }
    @Transactional
    public void delete(Long id) {

        Entregador entregador = entregadorRepository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);
        entregador.setVersao(entregador.getVersao() + 1);

        entregadorRepository.save(entregador);
     }
}
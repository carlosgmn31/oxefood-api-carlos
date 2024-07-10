package br.com.ifpe.oxefood.modelo.promocao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.transaction.Transactional;

 
@Service
public class PromocaoService {

    @Autowired
    private PromocaoRepository promocaoRepository;

    @Transactional
    public Promocao save(Promocao promocao) {

        promocao.setHabilitado(Boolean.TRUE);
        promocao.setVersao(1L);
        promocao.setDataCriacao(LocalDate.now());
        return promocaoRepository.save(promocao);

    }

    public List<Promocao> listarTodos() {

    return promocaoRepository.findAll();
    }

    public Promocao obterPorID(Long id) {

    return promocaoRepository.findById(id).get();
    }

    @Transactional
    public void delete(Long id){
        Promocao promocao = promocaoRepository.findById(id).get();
        promocao.setHabilitado(Boolean.FALSE);
        promocao.setVersao(promocao.getVersao()+1);

        promocaoRepository.save(promocao);
    }

    @Transactional
    public void update(Long id, Promocao promocaoAlterado) {
 
       Promocao promocao = promocaoRepository.findById(id).get();
       promocao.setTitulo(promocaoAlterado.getTitulo());
       promocao.setDataInicio(promocaoAlterado.getDataInicio());
       promocao.setDataFim(promocaoAlterado.getDataFim());
       promocao.setRegra(promocaoAlterado.getRegra());
       promocao.setValorDesconto(promocaoAlterado.getValorDesconto());
       promocao.setVersao(promocao.getVersao() + 1);
       promocaoRepository.save(promocao);
   } 
}

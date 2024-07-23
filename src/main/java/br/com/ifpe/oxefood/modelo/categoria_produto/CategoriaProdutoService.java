package br.com.ifpe.oxefood.modelo.categoria_produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        return categoriaProdutoRepository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoRepository.findAll();
    }

    public CategoriaProduto obterPorID(Integer id) {
        return categoriaProdutoRepository.findById(id).get();
    }

    @Transactional
    public void update(Integer id, CategoriaProduto categoriaProdutoAlterado) {

        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(id).get();
        categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());
        categoriaProduto.setVersao(categoriaProduto.getVersao() + 1);
        categoriaProdutoRepository.save(categoriaProduto);
    }

    @Transactional
    public void delete(Integer id) {

        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);
        categoriaProduto.setVersao(categoriaProduto.getVersao() + 1);

        categoriaProdutoRepository.save(categoriaProduto);
    }
    
}

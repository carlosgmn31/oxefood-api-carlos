package br.com.ifpe.oxefood.api.categoria_produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.categoria_produto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoria_produto.CategoriaProdutoService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

        CategoriaProduto categoriaProdutoNovo = request.build();
        CategoriaProduto categoriaProduto = categoriaProdutoService.save(categoriaProdutoNovo);
        return new ResponseEntity<CategoriaProduto>(categoriaProduto,HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody @Valid CategoriaProdutoRequest request) {

        categoriaProdutoService.update(id, request.build());
        return new ResponseEntity<CategoriaProduto>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaProduto> delete(@PathVariable Long id) {

        categoriaProdutoService.delete(id);
        return new ResponseEntity<CategoriaProduto>(HttpStatus.OK);
    }
    
}
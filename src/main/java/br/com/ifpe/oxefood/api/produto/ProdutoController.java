package br.com.ifpe.oxefood.api.produto;


import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(
    summary = "Serviço responsável por salvar um produto no sistema.",
    description = "Um endpoint responsável por inserir um produto no sistema."
    )
    @PostMapping
    public ResponseEntity<Produto> save (@RequestBody ProdutoRequest request) {

        Produto produto = produtoService.save(request.build());

        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }
    @Operation(
    summary = "Serviço responsável por listar os produtos do sistema.",
    description = "Um enpoint responsável por listar os produtos do sistema."
    )
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }
    @Operation(
    summary = "Serviço responsável por obter informações um produto do sistema.",
    description = "Um enpoint responsável por obter as informações de um produto do sistema, por id."
    )
    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }
    @Operation(
        summary = "Serviço responsável por atualizar um produto no sistema.",
        description = "Um enpoint responsável por atualizar as informações de um produto do sistema, usando id como parametro."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

    produtoService.update(id, request.build());
    return ResponseEntity.ok().build();
    }
    @Operation(
        summary = "Serviço responsável por deletar um produto no sistema.",
        description = "Um enpoint responsável por deletar as informações de um produtos do sistema, usando id como parametro."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
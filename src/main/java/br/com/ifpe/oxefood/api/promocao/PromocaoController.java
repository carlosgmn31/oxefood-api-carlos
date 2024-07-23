package br.com.ifpe.oxefood.api.promocao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.api.cliente.ClienteRequest;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.promocao.Promocao;
import br.com.ifpe.oxefood.modelo.promocao.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/promocao")
@CrossOrigin
public class PromocaoController {

    @Autowired
    private PromocaoService promocaoService;
    @Operation(
        summary = "Serviço responsável por salvar uma promocao no sistema.",
        description = "Um endpoint responsável por inserir uma promocao no sistema."
    )
    @PostMapping
    public ResponseEntity<Promocao> save(@RequestBody PromocaoRequest request) {

        Promocao promocao = promocaoService.save(request.build());

        return new ResponseEntity<Promocao>(promocao, HttpStatus.CREATED);
    }
    @Operation(
        summary = "Serviço responsável por listar todas as promocoes cadastradas no sistema.",
        description = "Um endpoint responsável por listar todas as promocoes cadastradas no sistema."
    )
    @GetMapping
    public List<Promocao> listarTodos() {
        return promocaoService.listarTodos();
    }

    @Operation(
        summary = "Serviço responsável por retornar uma promocao cadastrada no sistema.",
        description = "Um endpoint responsável por retornar uma promocao cadastrada no sistema, requer id."
    )
    @GetMapping("/{id}")
    public Promocao obterPorID(@PathVariable Long id) {
        return promocaoService.obterPorID(id);
    }

    @Operation(
        summary = "Serviço responsável por apagar uma promocao no sistema.",
        description = "Um endpoint responsável por deletar uma promocao no sistema, requer id."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        promocaoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
        summary = "Serviço responsável por atualizar um cliente no sistema.",
        description = "Um enpoint responsável por atualizar as informações de um cliente do sistema, usando id como parametro."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Promocao> update(@PathVariable("id") Long id, @RequestBody PromocaoRequest request) {

        promocaoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

}

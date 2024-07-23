package br.com.ifpe.oxefood.api.endereco;

import br.com.ifpe.oxefood.modelo.endereco.EnderecoCliente;
import br.com.ifpe.oxefood.modelo.endereco.EnderecoClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecoCliente")
@CrossOrigin
public class EnderecoClienteController {

    @Autowired
    private EnderecoClienteService enderecoClienteService;

    @PostMapping
    public ResponseEntity<EnderecoCliente> save(@RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente enderecoClienteNovo = request.build();
        EnderecoCliente enderecoCliente = enderecoClienteService.save(enderecoClienteNovo);
        return new ResponseEntity<EnderecoCliente>(enderecoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public List<EnderecoCliente> listarTodos() {
        return enderecoClienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public EnderecoCliente obterPorID(@PathVariable Long id) {
        return enderecoClienteService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoCliente> update(@PathVariable("id") Long id, @RequestBody @Valid EnderecoClienteRequest request) {

        enderecoClienteService.update(id, request.build());
        return new ResponseEntity<EnderecoCliente>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoCliente> delete(@PathVariable Long id) {

        enderecoClienteService.delete(id);
        return new ResponseEntity<EnderecoCliente>(HttpStatus.OK);
    }

}

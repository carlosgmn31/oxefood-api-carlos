package br.com.ifpe.oxefood.api.cliente;

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
import java.util.List;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

   @Autowired
   private ClienteService clienteService;
   @Operation(
    summary = "Serviço responsável por salvar um cliente no sistema.",
    description = "Um endpoint responsável por inserir um cliente no sistema."
)
   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }
   @Operation(
        summary = "Serviço responsável por listar os clientes do sistema.",
        description = "Um enpoint responsável por listar os clientes do sistema."
    )
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }
    @Operation(
        summary = "Serviço responsável por obter informações um cliente do sistema.",
        description = "Um enpoint responsável por obter as informações de um cliente do sistema, por id."
    )
    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }
    @Operation(
        summary = "Serviço responsável por atualizar um cliente no sistema.",
        description = "Um enpoint responsável por atualizar as informações de um cliente do sistema, usando id como parametro."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    @Operation(
        summary = "Serviço responsável por deletar um cliente no sistema.",
        description = "Um enpoint responsável por deletar as informações de um cliente do sistema, usando id como parametro."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }


}

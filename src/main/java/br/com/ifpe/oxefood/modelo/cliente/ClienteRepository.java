package br.com.ifpe.oxefood.modelo.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  // Um filtro de listagem de cliente que possibilita filtrar os clientes pelo
  // nome e pelo CPF;
  @Query("SELECT c FROM Cliente c WHERE c.cpf LIKE %:cpf%")
  List<Cliente> findByCpfLike(@Param("cpf") String cpf);

  // find by nome
  List<Cliente> findByNome(String nome);

  List<Cliente> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

  List<Cliente> findByCpfLikeAndNomeContainingIgnoreCaseOrderByNomeAsc(String cpf, String nome);

}

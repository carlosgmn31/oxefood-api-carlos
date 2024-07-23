package br.com.ifpe.oxefood.modelo.promocao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long>    {
}

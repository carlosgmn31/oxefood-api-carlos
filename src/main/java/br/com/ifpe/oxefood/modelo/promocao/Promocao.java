package br.com.ifpe.oxefood.modelo.promocao;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "Promocao")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promocao extends EntidadeAuditavel{
    @Column
    private String titulo;

    @Column
    private LocalDate dataInicio;

    @Column
    private LocalDate dataFim;

    @Column
    private String regra;

    @Column
    private Double valorDesconto;


}

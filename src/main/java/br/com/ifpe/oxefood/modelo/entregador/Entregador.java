package br.com.ifpe.oxefood.modelo.entregador;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {

    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String rg;
    @Column
    private LocalDate dataNascimento;
    @Column
    private String foneCelular;
    @Column
    private String foneFixo;
    @Column
    private Integer qtdEntregasRealizadas;
    @Column
    private Double valorFrete;
    @Column
    private String Rua;
    @Column
    private String NumeroRua;
    @Column
    private String Bairro;
    @Column
    private String Cidade;
    @Column
    private String Cep;
    @Column
    private String Uf;
    @Column
    private String Complemento;
    @Column
    private Boolean ativo;


}
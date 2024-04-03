package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    private Double valorFrete;
    private String Rua;
    private String NumeroRua;
    private String Bairro;
    private String Cidade;
    private String Cep;
    private String Uf;
    private String Complemento;
    private Boolean ativo;
    private String nome;
    private String cpf;
    private String rg;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String foneCelular;
    private String foneFixo;
    private Integer qtdEntregasRealizadas;

    public Entregador build() {

       return Entregador.builder()
                .ativo(ativo)
                .NumeroRua(NumeroRua)
                .Cidade(Cidade)
                .Bairro(Bairro)
                .Cep(Cep)
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .foneFixo(foneFixo)
                .Rua(Rua)
                .Complemento(Complemento)
                .Uf(Uf)
                .valorFrete(valorFrete)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .build();
    }
}
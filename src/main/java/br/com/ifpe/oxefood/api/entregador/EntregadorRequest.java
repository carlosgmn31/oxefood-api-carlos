package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

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
    private String enderecoRua;
    private String endercoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoUf;
    private String enderecoComplemento;
    private Boolean ativo;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String foneCelular;
    private String foneFixo;
    private Integer qtdEntregasRealizadas;

    public Entregador build() {

       return Entregador.builder()
                .ativo(ativo)
                .endercoNumero(endercoNumero)
                .enderecoCidade(enderecoCidade)
                .enderecoBairro(enderecoBairro)
                .enderecoCep(enderecoCep)
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .foneFixo(foneFixo)
                .enderecoRua(enderecoRua)
                .enderecoComplemento(enderecoComplemento)
                .enderecoUf(enderecoUf)
                .valorFrete(valorFrete)
                .build();
    }
}
package cesar.mendonca.guilherme.tabela_fip.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosModelo (@JsonAlias("codigo") String codigo,
                          @JsonAlias("nome") String nome) {
}

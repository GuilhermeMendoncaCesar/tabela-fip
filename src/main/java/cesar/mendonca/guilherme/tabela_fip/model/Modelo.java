package cesar.mendonca.guilherme.tabela_fip.model;

import lombok.Getter;

@Getter
public class Modelo {

    private String codigo;
    private String nome;

    public Modelo (DadosModelo dados) {
        this.codigo = dados.codigo();
        this.nome = dados.nome();
    }

    @Override
    public String toString() {
        return "Cód: " + this.getCodigo() + "  Descrição: " + this.getNome();
    }

}

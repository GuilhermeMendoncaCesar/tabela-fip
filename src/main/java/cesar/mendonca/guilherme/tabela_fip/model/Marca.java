package cesar.mendonca.guilherme.tabela_fip.model;

import lombok.Getter;

@Getter
public class Marca {

    private String codigo;
    private String nome;

    public Marca(DadosMarca dados) {
        this.codigo = dados.codigo();
        this.nome = dados.nome();
    }

    @Override
    public String toString() {
        return "Cód: " + this.getCodigo() + "  Descrição: " + this.getNome();
    }

}

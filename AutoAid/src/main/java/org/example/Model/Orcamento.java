package org.example.Model;

public class Orcamento extends Pecas{
    int id_orcamento;
    double valor_peca;
    double valor_reparo;

    public int getId_orcamento() {

        return id_orcamento;
    }

    public void setId_orcamento(int id_orcamento) {

        this.id_orcamento = id_orcamento;
    }

    public double getValor_peca() {

        return valor_peca;
    }

    public void setValor_peca(float valor_peca) {

        this.valor_peca = valor_peca;
    }

    public double getValor_reparo() {

        return valor_reparo;
    }

    public void setValor_reparo(float valor_reparo) {

        this.valor_reparo = valor_reparo;
    }

    public void gerarOrcamento(double valor_peca, double mao_Obra, int quantidade) {
        this.valor_peca = valor_peca;
        this.valor_reparo=mao_Obra;
        this.quantidade=quantidade;
        double servico = (valor_peca/2) + mao_Obra ;
        double orcamentoFinal = (valor_peca * quantidade)+ servico ;
        System.out.println("O orçamento final fica "+ orcamentoFinal+"$\nMão de obra = "+servico+"\nValor da Peça= "+valor_peca);
    }

}

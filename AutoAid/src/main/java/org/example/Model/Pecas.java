package org.example.Model;

public class Pecas{

    //int id_peca;
    String tipo_peca;
    double valor_peca;
    int quantidade;


    public Pecas(){}

    public Pecas(int quantidade,String tipo_peca,double valor_peca){
        this.valor_peca=valor_peca;
        this.quantidade=quantidade;
        this.tipo_peca=tipo_peca;
    }

    public String getTipo_peca() {

        return tipo_peca;
    }

    public void setTipo_peca(String tipo_peca) {

        this.tipo_peca = tipo_peca;
    }

    public void setValor_peca(char valor_peca) {

        this.valor_peca = valor_peca;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    public void removerPecas(String tipo_peca, int quantidade){
        this.tipo_peca=tipo_peca;
        this.quantidade=quantidade;
        System.out.println("Foi removida "+quantidade+" "+ tipo_peca +" no seu veículo");
    }
    public void adicionarPecas(String tipo_peca, int quantidade){
        this.tipo_peca=tipo_peca;
        this.quantidade=quantidade;
        System.out.println("Foi adicionada "+quantidade+" "+ tipo_peca +" no seu veículo");
    }
}

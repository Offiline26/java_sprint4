package org.example.Model;

//import DAO.Impl.ServicoImpl;

public class Servico {
    int id_servico;
    boolean conserto;
    boolean seguro;
    boolean guincho;
    int dia;
    int mes;
    String local_revisao;
    String descricao;
//    ServicoImpl servico = new ServicoImpl();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_servico() {
        return id_servico;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getLocal_revisao() {
        return local_revisao;
    }

    public void setLocal_revisao(String local) {
        this.local_revisao = local;
    }

    public void setId_servico(int id_servico) {

        this.id_servico = id_servico;
    }

    public void marcarRevisao(int mes, int dia, String local_revisao){
        this.mes = mes;
        this.dia = dia;
        this.local_revisao = local_revisao;
//        servico.marcarRevisao(this);
        System.out.println("Revisão marcada para "+dia+"/"+mes+" na: "+local_revisao);
    }

    public void analizeDiagnostico(String descricao){
        this.descricao = descricao;
//        servico.analizeDiagnostico(this);
        System.out.println("Descrição enviada para um profissional! Logo será retornado um resultado");
    }

    public boolean isSeguro() {
        return seguro;
    }

    public boolean isConserto() {
        return conserto;
    }

    public void setConserto(boolean conserto) {
        this.conserto = conserto;
    }

    public boolean isGuincho() {
        return guincho;
    }

    public void setGuincho(boolean guincho) {
        this.guincho = guincho;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }
}

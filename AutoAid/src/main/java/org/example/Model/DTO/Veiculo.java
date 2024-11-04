package org.example.Model.DTO;


import org.example.DAO.VeiculoDAO;

public class Veiculo {
    int id_veiculo;
    String modelo;
    String placa;
    String titular;
    String cnh;
    int ano;

    public Veiculo(){}

    public Veiculo(String modelo, String titular, String cnh,String placa, int ano){
        this.placa = placa;
        this.modelo = modelo;
        this.titular = titular;
        this.ano=ano;
        this.cnh = cnh;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getId_veiculo() {

        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {

        this.id_veiculo = id_veiculo;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    public String getPlaca() {

        return placa;
    }

    public void setPlaca(String placa) {

        this.placa = placa;
    }


    public int getAno() {

        return ano;
    }

    public void setAno(int ano) {

        this.ano = ano;
    }



}

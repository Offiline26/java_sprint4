package org.example.Model.DTO;

import java.time.LocalDate;

public class Usuario {
    String nome;
    String cpf;
    String rg;
    String datanasci;
    String email;
    String senha;
    String cep;
    String rua;
    int numero;
    String compl;
    String bairro;
    String cidade;
    String estado;

    public Usuario() {}

    public Usuario(String nome, String cpf, String rg, String datanasci, String email, String senha, String cep,
                   String rua, int numero, String compl, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.datanasci = datanasci;
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.compl = compl;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Getters e Setters
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDatanasci() {
        return datanasci;
    }

    public void setDatanasci(String datanasci) {
        this.datanasci = datanasci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCep() {

        return cep;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }


}
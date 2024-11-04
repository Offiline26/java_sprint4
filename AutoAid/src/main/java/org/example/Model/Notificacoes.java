package org.example.Model;

import java.util.Date;

public class Notificacoes {
    int id_noticacao;
    String mensagem;
    Date data_envio;
    boolean lida;

    public int getId_noticacao() {
        return id_noticacao;
    }

    public void setId_noticacao(int id_noticacao) {
        this.id_noticacao = id_noticacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData_envio() {
        return data_envio;
    }

    public void setData_envio(Date data_envio) {
        this.data_envio = data_envio;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }
}

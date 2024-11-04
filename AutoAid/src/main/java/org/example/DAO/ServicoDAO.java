package org.example.DAO;


import org.example.Model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServicoDAO {
    public void marcarRevisao(Servico servico) {

        String sql = "INSERT INTO t_revisaoData (mes,dia,local_revisao) VALUES (?,?,?)";
        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, servico.getMes());
            stmt.setInt(2, servico.getDia());
            stmt.setString(3, servico.getLocal_revisao());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro!"+e);
        }
    }

    public void analizeDiagnostico(Servico servico) {

        String sql = "INSERT INTO t_descricao (descricao) VALUES (?)";
        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, servico.getDescricao());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro! "+e);
        }
    }

}

package org.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexaoFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; // URL do banco de dados
    private static final String USER = "RM555352";
    private static final String PASSWORD = "260606";
    Statement st = null;

    // Método que retorna uma nova conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados: ", e);
        }
    }
}

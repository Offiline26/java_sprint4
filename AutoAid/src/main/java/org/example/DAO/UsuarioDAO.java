package org.example.DAO;


import org.example.Model.DTO.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO t_usuario (nome, cpf, rg, datanasci, email, senha, cep, rua, numero, compl, bairro , cidade, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            String dataStr = usuario.getDatanasci(); // Supondo que este método retorne uma String
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Ajuste o formato conforme necessário
            java.util.Date utilDate = format.parse(dataStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getRg());
            stmt.setDate(4, sqlDate);
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getCep());
            stmt.setString(8, usuario.getRua());
            stmt.setInt(9, usuario.getNumero());
            stmt.setString(10, usuario.getCompl());
            stmt.setString(11, usuario.getBairro());
            stmt.setString(12, usuario.getCidade());
            stmt.setString(13, usuario.getEstado());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro! " + e);
        }
    }

    public Usuario buscarUsuario(String cpf) {
        String sql = "SELECT * FROM t_usuario WHERE cpf = ? ";
        Usuario usuario = null;

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        rs.getString("datanasci"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getString("compl"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado")
                );
            } else {
                System.out.println("Cliente com CPF " + cpf + " não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return usuario;
    }

    public boolean cpfExiste(String cpf) {
        String sql = "SELECT COUNT(*) FROM t_usuario WHERE cpf = ?";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf); // Define o ID no PreparedStatement

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se a contagem for maior que zero
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar CPF: " + e.getMessage());
        }
        return false; // Retorna false se ocorrer erro ou se o CPF não existir
    }

    public List<Usuario> mostrarUsuarios() {
        String sql = "SELECT * FROM t_usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera pelo ResultSet e cria objetos Usuario para cada linha
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        rs.getString("datanasci"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getString("compl"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado")
                );
                usuarios.add(usuario);
            }

            // Verifica se algum veículo foi encontrado
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuario encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuario: " + e.getMessage());
        }

        return usuarios;
    }

    public void editarUsuario(Usuario usuario) {
        String sql = "UPDATE t_usuario SET nome = ?, rg = ?, datanasci = ?, email = ?, senha = ?, cep = ?, rua = ?, numero = ?, compl = ?, bairro = ?, cidade = ?, estado = ? WHERE cpf = ?";

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Converte a data para o formato SQL
            String dataStr = usuario.getDatanasci(); // Supondo que este método retorne uma String
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Ajuste o formato conforme necessário
            java.util.Date utilDate = format.parse(dataStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Define os parâmetros do PreparedStatement
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getRg());
            stmt.setDate(3, sqlDate);
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getCep());
            stmt.setString(7, usuario.getRua());
            stmt.setInt(8, usuario.getNumero());
            stmt.setString(9, usuario.getCompl());
            stmt.setString(10, usuario.getBairro());
            stmt.setString(11, usuario.getCidade());
            stmt.setString(12, usuario.getEstado());
            stmt.setString(13, usuario.getCpf()); // CPF para encontrar o registro a ser atualizado

            // Executa o update
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o CPF: " + usuario.getCpf());
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }



}

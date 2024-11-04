package org.example.DAO;


import org.example.Model.DTO.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    public void cadastrarVeiculo(Veiculo veiculo) {

        String sql = "INSERT INTO t_veiculo (modelo,titular,cnh, placa,ano,ativo) VALUES (?,?,?,?,?,?)";
        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, veiculo.getModelo());
                stmt.setString(2, veiculo.getTitular());
                stmt.setString(3, veiculo.getCnh());
                stmt.setString(4, veiculo.getPlaca());
                stmt.setInt(5, veiculo.getAno());
                stmt.setString(6, "TRUE");
                stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro! "+e);
        }
    }

    public Veiculo buscarVeiculo(String placa) {
        String sql = "SELECT * FROM t_veiculo WHERE placa = ? ";
        Veiculo veiculo = null;

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, placa);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                veiculo = new Veiculo(
                        rs.getString("modelo"),
                        rs.getString("titular"),
                        rs.getString("cnh"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                );
            } else {
                System.out.println("Veiculo com Placa " + placa + " não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return veiculo;
    }

    public boolean placaExiste(String placa) {
        String sql = "SELECT COUNT(*) FROM t_veiculo WHERE placa = ?";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa); // Define o ID no PreparedStatement

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se a contagem for maior que zero
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar Placa: " + e.getMessage());
        }
        return false; // Retorna false se ocorrer erro ou se a Placa não existir
    }

    public List<Veiculo> mostrarVeiculos() {
        String sql = "SELECT * FROM t_veiculo WHERE ativo = 'TRUE'";
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera pelo ResultSet e cria objetos Veiculo para cada linha
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("modelo"),
                        rs.getString("titular"),
                        rs.getString("cnh"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                );
                veiculos.add(veiculo);
            }

            // Verifica se algum veículo foi encontrado
            if (veiculos.isEmpty()) {
                System.out.println("Nenhum veículo encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar veículos: " + e.getMessage());
        }

        return veiculos;
    }

    public boolean deletarVeiculo(String placa) {
        String sql = "UPDATE t_veiculo SET ativo = 'FALSE' WHERE placa = ?";

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, placa);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Veículo com placa " + placa + " marcado como inativo.");
                return true;
            } else {
                System.out.println("Veículo com placa " + placa + " não encontrado.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro ao marcar veículo como inativo: " + e.getMessage());
            return false;
        }
    }

    public boolean editarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE t_veiculo SET modelo = ?, titular = ?, cnh = ?, ano = ? WHERE placa = ?";

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getTitular());
            stmt.setString(3, veiculo.getCnh());
            stmt.setInt(4, veiculo.getAno());
            stmt.setString(5, veiculo.getPlaca());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Veículo com placa " + veiculo.getPlaca() + " atualizado com sucesso.");
                return true;
            } else {
                System.out.println("Veículo com placa " + veiculo.getPlaca() + " não encontrado.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
            return false;
        }
    }


}



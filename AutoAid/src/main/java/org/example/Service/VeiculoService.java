package org.example.Service;

import org.example.DAO.VeiculoDAO;
import org.example.Model.DTO.Veiculo;

import java.util.List;

public class VeiculoService {

    private final VeiculoDAO veiculoDAO = new VeiculoDAO();

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        if (!veiculoDAO.placaExiste(veiculo.getPlaca())) {
            veiculoDAO.cadastrarVeiculo(veiculo);
            return true;
        }else {
            System.out.println("Placa já existente!");
            return false;
        }
    }

    public Veiculo buscarVeiculo(String placa) {
        return veiculoDAO.buscarVeiculo(placa);
    }

    public List<Veiculo> mostrarVeiculos(){ return veiculoDAO.mostrarVeiculos(); }

    public boolean deletarVeiculo(String placa){return veiculoDAO.deletarVeiculo(placa); }

    public boolean editar(Veiculo veiculo) {
        // Verifica se a Placa existe para evitar edição de um usuário não existente
        if (veiculoDAO.placaExiste(veiculo.getPlaca())) {
            veiculoDAO.editarVeiculo(veiculo);
            return true;
        } else {
            System.out.println("Usuário com CPF " + veiculo.getPlaca() + " não encontrado para edição.");
            return false;
        }
    }
}

package org.example.Service;

import org.example.DAO.UsuarioDAO;
import org.example.Model.DTO.Usuario;

import java.util.List;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean cadastrar(Usuario usuario) {
        if (!usuarioDAO.cpfExiste(usuario.getCpf())) {
            usuarioDAO.cadastrarUsuario(usuario);
            return true;
        }else {
            System.out.println("CPF já existente!");
            return false;
        }
    }

    public Usuario buscarDadosUsuario(String cpf) {
        return usuarioDAO.buscarUsuario(cpf);
    }

    public List<Usuario> mostrarUsuarios(){return usuarioDAO.mostrarUsuarios();}

    public boolean editar(Usuario usuario) {
        // Verifica se o CPF existe para evitar edição de um usuário não existente
        if (usuarioDAO.cpfExiste(usuario.getCpf())) {
            usuarioDAO.editarUsuario(usuario);
            return true;
        } else {
            System.out.println("Usuário com CPF " + usuario.getCpf() + " não encontrado para edição.");
            return false;
        }
    }
}

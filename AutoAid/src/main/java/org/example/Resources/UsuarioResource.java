package org.example.Resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.DTO.Usuario;
import org.example.Service.UsuarioService;

import java.util.List;

@Path("/usuario")
public class UsuarioResource {

    private final UsuarioService usuarioService = new UsuarioService();

    @Path("/cadastro")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario) {
        // Salva o produto utilizando a camada de serviço
        boolean usuarioCriado = usuarioService.cadastrar(usuario);

        // Retorna uma resposta 201 Created com o produto criado
        if (usuarioCriado) {
            return Response.status(Response.Status.CREATED).entity("Usuario cadastrado com sucesso").build();
        }else{
            return  Response.status(Response.Status.BAD_REQUEST).entity("Cadastro Falho!").build();
        }
    }


    @GET
    @Path("/dados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios(){
        List<Usuario> usuario = usuarioService.mostrarUsuarios() ;
        return Response.ok(usuario).build();
    }

    @GET
    @Path("/dados/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarDadosUsuario(@PathParam("cpf") String cpf) {
        Usuario usuarioDados = usuarioService.buscarDadosUsuario(cpf) ;
        return Response.ok(usuarioDados).build();
    }

    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarUsuario(Usuario usuario) {
        boolean usuarioEditado = usuarioService.editar(usuario);

        if (usuarioEditado) {
            return Response.ok("Usuário atualizado com sucesso").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Atualização Falha!").build();
        }

    }
}

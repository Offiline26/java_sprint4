package org.example.Resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.DTO.Veiculo;
import org.example.Service.VeiculoService;

import java.util.List;

@Path("/veiculo")
public class VeiculoResource {

    private final VeiculoService veiculoService = new VeiculoService();

    @Path("/cadastro")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Veiculo veiculo) {
        // Salva o produto utilizando a camada de serviço
        boolean veiculoCriado = veiculoService.cadastrarVeiculo(veiculo);

        // Retorna uma resposta 201 Created com o produto criado
        if (veiculoCriado) {
            return Response.status(Response.Status.CREATED).entity("Veiculo cadastrado com sucesso").build();
        }else{
            return  Response.status(Response.Status.BAD_REQUEST).entity("Cadastro do veículo Falho!").build();
        }
    }

    @GET
    @Path("/dados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVeiculos() {
        List<Veiculo> veiculo = veiculoService.mostrarVeiculos();
        return Response.ok(veiculo).build();
    }

    @GET
    @Path("/dados/{placa_veiculo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarVeiculo(@PathParam("placa_veiculo") String placaVeiculo) {
        Veiculo veiculoDados = veiculoService.buscarVeiculo(placaVeiculo) ;
        return Response.ok(veiculoDados).build();
    }


    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarVeiculo(Veiculo veiculo) {
        boolean veiculoEditado = veiculoService.editar(veiculo);

        if (veiculoEditado) {
            return Response.ok("Veiculo atualizado com sucesso").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Atualização Falha!").build();
        }

    }

    @DELETE
    @Path("/deletar/{placa_veiculo}")
    public Response deletarVeiculo(@PathParam("placa_veiculo") String placaVeiculo) {
        boolean veiculoDeletado = veiculoService.deletarVeiculo(placaVeiculo);

        if (veiculoDeletado) {
            return Response.ok("Veículo com placa " + placaVeiculo + " marcado como inativo.").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Veículo com placa " + placaVeiculo + " não encontrado.").build();
        }
    }

}
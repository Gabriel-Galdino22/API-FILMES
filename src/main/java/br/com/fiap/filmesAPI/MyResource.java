package br.com.fiap.filmesAPI;

import java.util.List;

import br.com.fiap.filmesAPI.model.*;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import service.FilmeService;

@Path("filme")
public class MyResource {
	
	private FilmeService service = new FilmeService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Filme> listAll() {
        return service.findAll(); 
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
    	var filme = service.findById(id);
    	    	
    	if (filme == null) {
    		return Response.status(404).build();
    	}
    	
    	return Response.ok(filme).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
    	var filme = service.findById(id);
    	
    	if(filme == null)
    		return Response.status(404).build();
    	
    	service.delete(filme);
    	return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Filme filme){
    	if (!service.save(filme)) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	return Response.ok(filme).build();
    	
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Filme filme) {
    	var filmeEncontrado = service.findById(id);
    	
    	if(filmeEncontrado == null)
    		return Response.status(Response.Status.NOT_FOUND).build();
    			
    			
    	if (!service.update(filme))
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	
    	return Response.ok(filme).build();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
}
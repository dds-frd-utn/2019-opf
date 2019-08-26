/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;
import util.RESTFul;
import utn.frd.mavenproject2.Cliente;

/**
 *
 * @author Pablo
 */
@Stateless
@Path("cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "utn.frd_mavenproject2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        //llamar al banco central
        super.create(entity);
    }

    @POST
    @Path("{id}")
    public void create(@PathParam("id") Integer id) throws JSONException {
        //llamar al banco central
        String ciudadanoStr = RESTFul.makeGetRequest("http://lsi.no-ip.org:8282/esferopolis/api/ciudadano/"+id);
       //convertir el string en un objeto
       JSONObject o = new JSONObject(ciudadanoStr);
       
       
       Cliente entity = new Cliente();
       entity.setDireccion( o.getString("direccion") );
       entity.setEstadoCrediticio( o.getString("estadoCrediticio") );
       //entity.setFechaNacimiento( o.getString("fechaNacimiento") );
       //entity.setId ( o.getString("id") );
       entity.setNombre( o.getString("nombre") );
       
       super.create(entity);
        
       //RESTFul.enviarHttpRequest(url,"POST",o);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

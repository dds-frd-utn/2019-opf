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
import utn.frd.mavenproject2.Transacciones;

/**
 *
 * @author Pablo
 */
@Stateless
@Path("transacciones")
public class TransaccionesFacadeREST extends AbstractFacade<Transacciones> {

    @PersistenceContext(unitName = "utn.frd_mavenproject2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public TransaccionesFacadeREST() {
        super(Transacciones.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Transacciones entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Transacciones entity) {
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
    public Transacciones find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("tip/{tipo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Transacciones find(@PathParam("tipo") String tipo) {
        return super.find(tipo);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacciones> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacciones> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

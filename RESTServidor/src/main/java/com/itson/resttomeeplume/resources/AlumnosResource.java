/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.itson.resttomeeplume.resources;

import com.itson.restentidades.Alumno;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Web Service
 *
 * @author yohan
 */
@Path("Alumnos")
@RequestScoped
public class AlumnosResource {

    @Context
    private UriInfo context;
    @PersistenceContext
    private EntityManager em;

    /**
     * Creates a new instance of AlumnosResource
     */
 

    //consultar por un parametro especifico
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnos() {
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumnos a", Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        return Response.ok(alumnos).build();
    }

    //Agregar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAlumno(Alumno a) {
        em.persist(a);
        return Response.status(Response.Status.CREATED).entity(a).build();
    }
//actualizar

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAlumno(@PathParam("id") Long id, Alumno updatedAlumno) {
        Alumno a = em.find(Alumno.class, id);
        if (a == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        a.setNombre(updatedAlumno.getNombre());
        em.merge(a);
        return Response.ok(a).build();
    }
    //borrar 

    @DELETE
    @Path("{id}")
    public Response deleteAlumno(@PathParam("id") Long id) {
        Alumno a = em.find(Alumno.class, id);
        if (a == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(a);
        return Response.noContent().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnoById(@PathParam("id") Long id) {
        Alumno a = em.find(Alumno.class, id);
        if (a == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(a).build();
    }
}
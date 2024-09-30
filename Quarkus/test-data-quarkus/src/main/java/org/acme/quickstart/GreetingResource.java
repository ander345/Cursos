package org.acme.quickstart;

import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/dev")
public class GreetingResource {

    /**
     * hibernate orm
     */

   // @Inject
    //EntityManager entityManager;

    /*@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer getDev(@PathParam("id") Integer id) {
        return entityManager.find(Developer.class, id);

    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Developer developer) {

        entityManager.persist(developer);

        return Response.created(URI.create("/dev/" + developer.getId()))
                .build();
    }*/

    //con panache
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DeveloperPanache getDev(@PathParam("id") Long id) {
        return DeveloperPanache.findById( id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeveloperPanache> getAllDevs() {
        return DeveloperPanache.findAll().list();
    }

    /*@GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public DeveloperPanache findByName(@NotNull @PathParam( "name") String name) {
        return DeveloperPanache.find("name", name).firstResult();
    }*/

    @GET
    @Path("/{name}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeveloperPanache> findByNameAndAge(@NotNull @PathParam("name") String name, @NotNull @PathParam("age") Integer age) {
        return DeveloperPanache.find("name = ?1 and age = ?2", name, age).firstResult();
    }


    /*@POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(DeveloperPanache developer) {

        developer.persist();

        return Response.created(URI.create("/dev/" + developer.id))
                .build();
    }*/

    //DaO pattern

    @Inject
    DeveloperRepository developerRepository;

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findByName(@NotNull @PathParam( "name") String name) {
        return developerRepository.findByName(name);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Developer developer) {

       developerRepository.create(developer);

        return Response.created(URI.create("/dev/" + developer.getId()))
                .build();
    }


}

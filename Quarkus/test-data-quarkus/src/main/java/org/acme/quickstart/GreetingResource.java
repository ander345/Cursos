package org.acme.quickstart;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/dev")
public class GreetingResource {

    @Inject
    EntityManager entityManager;

    @GET
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
    }
}

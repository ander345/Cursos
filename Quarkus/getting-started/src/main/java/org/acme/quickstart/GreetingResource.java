package org.acme.quickstart;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    String msg;

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return greetingService.toUpperCase(msg);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/beer")
    public BeerExampleJson getBeerExampleJson() {
        return new BeerExampleJson("Alhambra", 300);
    }

    @POST
    @Path("/beer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeerExampleJson(@Valid BeerExampleJson beerExampleJson) {
        System.out.println(beerExampleJson);
        return Response.ok().build();
    }
}

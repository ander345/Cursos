package org.acme.quickstart;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.quickstart.validations.BeerExampleOwnValidations;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;


@Path("/hello")
public class GreetingResource {

    Logger logger = Logger.getLogger(GreetingResource.class);

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
        logger.debug(beerExampleJson);
        return Response.ok().build();
    }

    /**
     * Ejemplo con validacion propia
     */
    @POST
    @Path("/beer/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeerExampleJsonValidate(@Valid BeerExampleOwnValidations beer) {
        System.out.println(beer);
        return Response.ok().build();
    }
}

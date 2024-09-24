package org.acme.quickstart;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.quickstart.service.RealExpensive;
import org.acme.quickstart.service.WorldClock;
import org.acme.quickstart.service.WorldClockHeaders;
import org.acme.quickstart.service.WorldClockService;
import org.acme.quickstart.validations.BeerExampleOwnValidations;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;


@Path("/hello")
public class GreetingResource {

    Logger logger = Logger.getLogger(GreetingResource.class);

    @ConfigProperty(name = "greeting.message")
    String msg;

    //cambio por regla de sonar-----------------------
    //@Inject
    //GreetingService greetingService;

    private final GreetingService greetingService;

    @Inject
    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    //--------------------------------------------------------------


    //1
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

    // 2
    @POST
    @Path("/beer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeerExampleJson(@Valid BeerExampleJson beerExampleJson) {
        logger.debug(beerExampleJson);
        return Response.ok().build();
    }

    //3
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

    //4

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/nowservice")
    public WorldClock getNow() {
        //opcion 1
        //WorldClockHeaders worldClockHeaders = new WorldClockHeaders();
        //return worldClockService.getNow(worldClockHeaders);

        //opcion 2 con Client rest Rest
        return ClientBuilder.newClient().target("http://worldclockapi.com")
                .path("/json/cet/now")
                .request(MediaType.APPLICATION_JSON)
                .get(WorldClock.class);
    }

    //5 para test mock

    @Inject
    RealExpensive realExpensive;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mock")
    public int mock(){
        return realExpensive.calculate();
    }
}

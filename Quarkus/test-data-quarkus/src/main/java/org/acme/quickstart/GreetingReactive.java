package org.acme.quickstart;

//import io.reactivex.Flowable;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.reactivestreams.Publisher;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/reactive")
public class GreetingReactive {

    // libreria reactiva quarkus-smallrye-reactive-streams-operators
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> getDev() {
        return ReactiveStreams.of("hello", "world")
                .map(String::toUpperCase)
                .toList()
                .run()
                .thenApply(list -> list.toString());

    }

    private AtomicInteger atomicInteger = new AtomicInteger();

   /* @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @Path("/stream")
    public Publisher<String> stream() {
        return Flowable.interval(500, TimeUnit.MILLISECONDS)
                .map(s ->atomicInteger.getAndIncrement())
                .map(i -> Integer.toString(i));
    }*/

}

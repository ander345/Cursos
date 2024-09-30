package org.acme.quickstart;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ConsumerData {

    @Incoming("my-in-memory")
    public void consume(Integer number) {
        System.out.println("Got: " + number);
    }

}

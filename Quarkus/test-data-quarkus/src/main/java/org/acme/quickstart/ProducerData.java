package org.acme.quickstart;

import io.reactivex.Flowable;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class ProducerData {

    @Outgoing("my-in-memory")
    public Flowable<Integer> generate() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(tick -> (int) (Math.random() * 100));
    }
}

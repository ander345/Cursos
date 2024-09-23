package org.acme.quickstart;


import jakarta.enterprise.context.ApplicationScoped;

/**
 * ApplicationScoped es como el cilco de vida, como un singleton
 * un resourse seria como un objeto por cada request
 */
@ApplicationScoped
public class GreetingService {

    public String toUpperCase(String msg) {
        return msg.toUpperCase();
    }
}

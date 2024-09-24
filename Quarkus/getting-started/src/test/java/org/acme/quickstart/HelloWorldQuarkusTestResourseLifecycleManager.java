package org.acme.quickstart;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldQuarkusTestResourseLifecycleManager implements QuarkusTestResourceLifecycleManager {
    @Override
    public Map<String, String> start() {
        System.out.println("Se van a ejecutar los test");
        Map<String, String> conf = new HashMap<>();
        conf.put("greeting.message", "Aloha Test");
        return conf;
    }

    @Override
    public void stop() {
        System.out.println("se ejecutaron los test");
    }
}

package org.acme.quickstart;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(HelloWorldQuarkusTestResourseLifecycleManager.class)
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(CoreMatchers.is("ALOHA TEST"));
    }

    @Disabled
    @Test
    void testMockEndpoint() {
        given()
                .when().get("/hello/mock")
                .then()
                .statusCode(200)
                .body(CoreMatchers.is("20"));
    }

}
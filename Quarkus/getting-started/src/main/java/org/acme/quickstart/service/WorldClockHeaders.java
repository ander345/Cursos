package org.acme.quickstart.service;

import jakarta.ws.rs.HeaderParam;

public class WorldClockHeaders {

     @HeaderParam("X-Logger")
    String logger;
}

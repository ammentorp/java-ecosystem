package com.contrastsecurity;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public class JerseyEndpoint {
    @GET
    @Path("/ping")
    public Response png() {
        System.out.println("PAGE REFRESHED");

        return Response.ok("Hello World").build();
    }
}

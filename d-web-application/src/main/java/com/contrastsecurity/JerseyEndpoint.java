package com.contrastsecurity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class JerseyEndpoint {
    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok("Hello World").build();
    }
}

package com.contrastsecurity;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

@Path("/add")
public class AdditionEndpoint {

    @GET
    public Response add() throws FileNotFoundException {
        System.out.println("PAGE REFRESHED");

        URL resource = getClass().getClassLoader().getResource("add.html");

        File file = new File(resource.getFile());

        FileInputStream f = new FileInputStream(file);

        return Response.ok(f).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String addNums (@FormParam("a") Integer a, @FormParam("b") Integer b) {
        return a + " + " + b + " = " + (a+b);
    }
}
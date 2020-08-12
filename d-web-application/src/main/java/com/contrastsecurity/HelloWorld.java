package com.contrastsecurity;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



@ApplicationPath("api")
public class HelloWorld {
    @GET
    @Path("/ping")
    public static void main(String[] args) {

    }
}


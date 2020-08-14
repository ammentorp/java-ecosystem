package com.contrastsecurity;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

public class HelloWorld extends ResourceConfig {

    public static void main(String[] args) throws IOException {

        final ResourceConfig resourceConfig = ResourceConfig.forApplication(new TestApplication());

        HttpServer httpServer =
                GrizzlyHttpServerFactory.createHttpServer(UriBuilder.fromUri("http://localhost/").port(8080).build(), resourceConfig, false);

        httpServer.start();
    }
}


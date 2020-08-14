package com.contrastsecurity;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.core.UriBuilder;
//import java.io.IOException;

// Grizzly
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

// Jetty
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

public class HelloWorld extends ResourceConfig {

    public static void main(String[] args) throws Exception {

        final ResourceConfig resourceConfig = ResourceConfig.forApplication(new TestApplication());

//        // Grizzly
//        HttpServer httpServer =
//                GrizzlyHttpServerFactory.createHttpServer(UriBuilder.fromUri("http://localhost/").port(8080).build(), resourceConfig, false);
//        // throws IOException
//        httpServer.start();

        // Jetty
        Server server =
                JettyHttpContainerFactory.createServer(UriBuilder.fromUri("http://localhost/").port(8080).build(), resourceConfig, false);

        // throws Exception
        server.start();

    }
}


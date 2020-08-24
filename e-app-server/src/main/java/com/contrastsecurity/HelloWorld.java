package com.contrastsecurity;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet(
        urlPatterns = "/ping",
        loadOnStartup = 1,
        asyncSupported = true
)
public class HelloWorld extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet has been initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().println("Hello World");
    }

}


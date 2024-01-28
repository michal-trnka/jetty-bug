package org.example;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;


public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8666); // Set server port

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Map servlet to the path
        context.addServlet(new ServletHolder(new PostHandlerServlet()), "/post");

        server.start();
        server.join();
    }
}

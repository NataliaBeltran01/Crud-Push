/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jettyserverpush;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.PushServlet;

/**
 * @author christmo
 */
public class JettyServerPush {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new PushServlet()), "/*");

        server.start();
        server.join();
    }
}

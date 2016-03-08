package test.jersey;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletMapping;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import test.jersey.resource.CrawlerResource;
import test.jersey.resource.StatusResource;

public class Application {
  public static void main(String[] args) throws Exception {
    Server server = new Server(new QueuedThreadPool(10, 10));

    ServerConnector connector = new ServerConnector(server, 1, 1);
    connector.setPort(8080);
    server.setConnectors(new Connector[] { connector });

    ResourceConfig rc = new ResourceConfig();
    rc.register(JacksonFeature.class);
    rc.register(CrawlerResource.class);
    rc.register(StatusResource.class);

    ServletMapping servletMapping = new ServletMapping();
    servletMapping.setServletName("jersey");
    servletMapping.setPathSpec("/*");

    ServletHandler handler = new ServletHandler();
    handler.addServlet(new ServletHolder("jersey",  new ServletContainer(rc)));
    handler.addServletMapping(servletMapping);

    ServletContextHandler servletContextHandler = new ServletContextHandler();
    servletContextHandler.setServletHandler(handler);

    ContextHandlerCollection contexts = new ContextHandlerCollection();
    contexts.setHandlers(new Handler[]{ servletContextHandler });

    server.setHandler(contexts);

    server.start();
    server.join();
  }
}

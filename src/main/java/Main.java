import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.ListStorageService;
import servlet.ListServlet;


public class Main {

    private static final int PORT = 8090;

    public static void main(String[] args) throws Exception{

        ListStorageService storageService = ListStorageService.getInstance();

        ServletContextHandler contextHandler =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new ListServlet(storageService)), "/api/lists");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[]{resource_handler, contextHandler});

        Server server = new Server(PORT);
        server.setHandler(handlerList);

        server.start();
        System.out.println("Server is started on port: " + PORT);
        System.out.println("For exit press CTRL + C");
        server.join();

    }
}

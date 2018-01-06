import DataBase.DataBaseHelper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;


public class Main {



    public static void main (String... args)
    {

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        HelloServlet servlet = new HelloServlet();

       /* DataBaseHelper dataBaseHelper = new DataBaseHelper("ORM");


        contextHandler.addServlet(new ServletHolder(new LoginServlet(dataBaseHelper)), "/login");
        contextHandler.addServlet(new ServletHolder(new CategoryServlet(dataBaseHelper)), "/category");
        contextHandler.addServlet(new ServletHolder(new DishServlet(dataBaseHelper)), "/dish");
        contextHandler.addServlet(new ServletHolder(new MakeOrderServlet(dataBaseHelper)), "/order.new");
        contextHandler.addServlet(new ServletHolder(new GetUsersOrdersServlet(dataBaseHelper)), "/order.get");*/

        contextHandler.addServlet(new ServletHolder(servlet), "/hello");
        Server server = new Server(8080);
        System.out.println("Connectors count: " + server.getConnectors().length);
        server.setHandler(contextHandler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("nu yobana");
        }

    }

}

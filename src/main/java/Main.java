import DataBase.DataBaseHelper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.CategoryServlet;
import servlets.DishServlet;
import servlets.LoginServlet;
import servlets.MakeOrderServlet;


public class Main {



    public static void main (String... args)
    {

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        HelloServlet servlet = new HelloServlet();

        DataBaseHelper dataBaseHelper = new DataBaseHelper("ORM");

        contextHandler.addServlet(new ServletHolder(servlet), "/hello");
        contextHandler.addServlet(new ServletHolder(new LoginServlet(dataBaseHelper)), "/login");
        contextHandler.addServlet(new ServletHolder(new CategoryServlet(dataBaseHelper)), "/category");
        contextHandler.addServlet(new ServletHolder(new DishServlet(dataBaseHelper)), "/dish");
        contextHandler.addServlet(new ServletHolder(new MakeOrderServlet(dataBaseHelper)), "/order.new");


        Server server = new Server(8080);
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

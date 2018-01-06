import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class HelloServlet extends HttpServlet {


    public HelloServlet (){}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        resp.getWriter().println(req.getParameter("key"));

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

       // DataBase.DataBaseHelper helper = new DataBase.DataBaseHelper();


       
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("Привет Yobana");
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}

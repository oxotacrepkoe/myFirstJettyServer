package servlets;

import DataBase.DataBaseHelper;
import DataBase.DataSet.OrderDataSet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetUsersOrdersServlet extends HttpServlet {

    private DataBaseHelper dbHelper;


    public GetUsersOrdersServlet(DataBaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        long user_id = Long.parseLong(req.getParameter("user_id"));

        List<OrderDataSet> orders = dbHelper.getOrders(user_id);

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(new Gson().toJson(orders));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

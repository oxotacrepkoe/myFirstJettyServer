package servlets;


import DataBase.DataBaseHelper;
import DataBase.DataSet.UserDataSet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeOrderServlet extends HttpServlet{

    private DataBaseHelper dataBaseHelper;

    public MakeOrderServlet(DataBaseHelper dataBaseHelper) {
        this.dataBaseHelper = dataBaseHelper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        resp.setContentType("text/html; charset=UTF-8");

        String raw_order = req.getParameter("raw_order");
        Long user_id = Long.parseLong(req.getParameter("user_id"));

        UserDataSet user = dataBaseHelper.getUserById(user_id);
        if (user != null && user.getId() == user_id) {
            dataBaseHelper.addOrder(user_id, raw_order);
            resp.getWriter().println("accepted");
        } else {
            resp.getWriter().println("denied");
        }

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

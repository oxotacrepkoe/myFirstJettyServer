package servlets;

import DataBase.DataBaseHelper;
import DataBase.DataSet.UserDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class LoginServlet extends HttpServlet {

    private DataBaseHelper dbHelper;

    public LoginServlet(DataBaseHelper helper) {
        dbHelper = helper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String login = req.getParameter("login");
        String password = req.getParameter("password");


        UserDataSet dataSet = dbHelper.userLogin(login);

        resp.setContentType("text/html; charset=UTF-8");

        if (dataSet != null && dataSet.getPassword().equals(password)) {
            resp.getWriter().println(dataSet.toString());
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        resp.getWriter().println("404");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

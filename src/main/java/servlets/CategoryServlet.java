package servlets;


import DataBase.DataBaseHelper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends HttpServlet {

    private DataBaseHelper dataBaseHelper;

    public CategoryServlet(DataBaseHelper dataBaseHelper) {
        this.dataBaseHelper = dataBaseHelper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.getWriter().println(new Gson().toJson(dataBaseHelper.getCategorys()));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

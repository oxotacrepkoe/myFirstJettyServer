package servlets;

import DataBase.DataBaseHelper;
import DataBase.DataSet.DishDataSet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class DishServlet extends HttpServlet {

    private DataBaseHelper dataBaseHelper;

    public DishServlet(DataBaseHelper dataBaseHelper) {
        this.dataBaseHelper = dataBaseHelper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        Long category_id = Long.parseLong(req.getParameter("category_id"));
        List<DishDataSet> res = dataBaseHelper.getDishes(category_id);

        resp.getWriter().println(new Gson().toJson(res));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

package DataBase.DAO;


import DataBase.DataSet.CategoryDataSet;
import org.hibernate.Session;

import java.util.List;

public class CategoryDAO {

    private Session session;

    public CategoryDAO(Session session) {
        this.session = session;
    }

    public List<CategoryDataSet> get () {
        return ((List<CategoryDataSet>)  session.createCriteria(CategoryDataSet.class).list());
    }

    public long insert (String title, String color, byte[] picture) {
        return (Long) session.save(new CategoryDataSet(title, color));
    }
}

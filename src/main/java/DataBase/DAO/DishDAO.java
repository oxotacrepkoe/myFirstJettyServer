package DataBase.DAO;


import DataBase.DataSet.DishDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

public class DishDAO implements Serializable{

    private Session session;

    public DishDAO(Session session) {
        this.session = session;
    }

    public List<DishDataSet> get (long category_id) {
        Criteria criteria = session.createCriteria(DishDataSet.class);
        return ((List<DishDataSet>) criteria.add(Restrictions.eq("category_id", category_id)).list());
    }

    public long insert (DishDataSet dish) {
        return (Long) session.save(dish);
    }
}

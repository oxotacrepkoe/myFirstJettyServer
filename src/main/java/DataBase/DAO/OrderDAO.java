package DataBase.DAO;

import DataBase.DataSet.OrderDataSet;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;


public class OrderDAO implements Serializable {

    private Session session;

    public OrderDAO(Session session) {
        this.session = session;
    }

    public List<OrderDataSet> get (long user_id) {
        return (List<OrderDataSet>) session.createCriteria(OrderDataSet.class).add(Restrictions.eq("user_id", user_id)).list();
    }

    public long insert (long user_id, String raw_order) {
        return (Long) session.save(new OrderDataSet(user_id, raw_order));
    }
}

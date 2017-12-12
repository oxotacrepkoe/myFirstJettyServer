package DataBase;

import DataBase.DAO.CategoryDAO;
import DataBase.DAO.DishDAO;
import DataBase.DAO.OrderDAO;
import DataBase.DAO.UserDAO;
import DataBase.DataSet.CategoryDataSet;
import DataBase.DataSet.DishDataSet;
import DataBase.DataSet.OrderDataSet;
import DataBase.DataSet.UserDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.List;
import java.util.Properties;


public class DataBaseHelper {

    public static final String RAW = "RAW";
    public static final String ORM = "ORM";

    private final SessionFactory sessionFactory;

    private Driver driver;
    private Connection connection;
    private Configuration config;



    public DataBaseHelper (String type) {

        switch (type)
       {
           case "RAW" :
               startRawDataBaseHelper();
               break;

           case "ORM" :
               startORM();
               break;

           default: startORM();
       }
        sessionFactory = createSessionFactory(config);
    }



    private void startORM ()
    {
        config = new Configuration();
        config.addAnnotatedClass(UserDataSet.class);
        config.addAnnotatedClass(OrderDataSet.class);
        config.addAnnotatedClass(CategoryDataSet.class);
        config.addAnnotatedClass(DishDataSet.class);
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test?useUnicode=true&characterEncoding=utf8");
        config.setProperty("hibernate.connection.username", "postgres");
        config.setProperty("hibernate.connection.password", "user0123");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.connection.characterEncoding", "utf8");
        config.setProperty("hibernate.connection.CharSet", "utf8");
        config.setProperty("hibernate.connection.useUnicode", "true");
        config.setProperty("hibernate.hbm2ddl.auto", "update");

    }


    public UserDataSet userLogin (String login) {
        Session session = sessionFactory.openSession();
        UserDataSet result = new UserDAO(session).signIn(login);
        session.close();
        return result;
    }


    public boolean userRegister (String name, String login, String password) {

        Session session = sessionFactory.openSession();
        Long res = new UserDAO(session).insertUser(name, login, password);
        session.close();

        if (res > 0) return true;

        return false;
    }


    public List<CategoryDataSet> getCategorys() {

        Session session = sessionFactory.openSession();
        CategoryDAO dao = new CategoryDAO(session);
        List<CategoryDataSet> res = dao.get();
        session.close();

        return res;
    }


    public List<DishDataSet> getDishes (long category_id) {

        Session session = sessionFactory.openSession();
        DishDAO dao = new DishDAO(session);
        List<DishDataSet> res = dao.get(category_id);
        session.close();
        return res;
    }

    public void addOrder(long user_id, String raw_order) {
        Session session = sessionFactory.openSession();
        OrderDAO dao = new OrderDAO(session);
        dao.insert(user_id, raw_order);
        session.close();
    }

    public UserDataSet getUserById (long user_id) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAO(session);
        UserDataSet res = dao.getById(user_id);
        session.close();
        return res;
    }






//---------manual DataBase code--------------------//


    private void startRawDataBaseHelper ()
    {
        try {
            driver = (Driver) Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.registerDriver(driver);

            String url = "jdbc:postgresql://localhost:5432/test";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","user0123");
            //props.setProperty("ssl","true");
            connection = DriverManager.getConnection(url, props);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public int execUpdate(String request) throws SQLException {

        int updated = 0;

        Statement statement = connection.createStatement();
        statement.execute(request);
        updated = statement.getUpdateCount();
        statement.close();

        return updated;
    }


    public <T> T execQuery(String request, ResultHandler handler) throws SQLException {

        Statement statement = connection.createStatement();
        statement.execute(request);
        ResultSet resultSet = statement.getResultSet();

        T entety = handler.<T>handle(resultSet);

        resultSet.close();
        statement.close();

        return entety;
    }


    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}

package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface ResultHandler {

   public  <T> T handle (ResultSet result) throws SQLException;

}

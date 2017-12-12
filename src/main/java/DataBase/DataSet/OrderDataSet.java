package DataBase.DataSet;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table (name = "order_stack")
public class OrderDataSet implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "order_stack")
    private String raw_order;

//--------------------------------------------------------------------------------//

    @SuppressWarnings("UnusedDeclaration")
    public OrderDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public OrderDataSet(long user_id, String raw_order) {
        this.user_id = user_id;
        this.raw_order = raw_order;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getRaw_order() {
        return raw_order;
    }

    public void setRaw_order(String raw_order) {
        this.raw_order = raw_order;
    }
}

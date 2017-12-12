package DataBase.DataSet;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "dish")
public class DishDataSet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "category_id")
    private long category_id;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Column(name = "price")
    private float price;


//--------------------------------------------------------------------------------//

    @SuppressWarnings("UnusedDeclaration")
    public DishDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public DishDataSet(String title, long category_id, String description, String picture, float price, String title1) {
        this.title = title;
        this.category_id = category_id;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.title = title1;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

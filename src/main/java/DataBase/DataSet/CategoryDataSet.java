package DataBase.DataSet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
public class CategoryDataSet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "title", unique = true)
    private String title;


    @Column(name = "color")
    private String color;


    @Column(name = "picture", unique = true)
    private String picture;


//--------------------------------------------------------------------------------//

    @SuppressWarnings("UnusedDeclaration")
    public CategoryDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public CategoryDataSet(String title, String color, String picture) {
        this.title = title;
        this.color = color;
        this.picture = picture;
    }


    public CategoryDataSet(String title, String color) {
        this.title = title;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

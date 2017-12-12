package DataBase.DataSet;


import com.google.gson.Gson;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "users")
public class UserDataSet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", unique = true, updatable = false)
    private String name;


    @Column(name = "avatar", unique = true)
    private String avatar;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password", updatable = false)
    private String password;


//--------------------------------------------------------------------------------//


    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}

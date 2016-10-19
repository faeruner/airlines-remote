package by.pvt.module4.model;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {
    List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

package by.pvt.module4.model;

import by.pvt.module4.common.CommonEntityListImpl;

import java.util.List;

public class Users extends CommonEntityListImpl<User> {

    public Users() {
        super();
    }

    public Users(List<User> users) {
        super(users);
    }

    public List<User> getUsers() {
        return getEntity();
    }

    public void setUsers(List<User> users) {
        setEntity(users);
    }
}

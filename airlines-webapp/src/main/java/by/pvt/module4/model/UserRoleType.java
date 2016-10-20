package by.pvt.module4.model;

public enum UserRoleType {
    DISPATCHER(2), ADMINISTRATOR(1), GUEST(0);

    private Integer id;

    UserRoleType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
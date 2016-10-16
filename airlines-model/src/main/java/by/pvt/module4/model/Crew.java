package by.pvt.module4.model;

import by.pvt.module4.common.Fact;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Crew implements Serializable, Fact {
    public static final String ID = "id";
    public static final String CREATE_DATE = "create_date";
    public static final String READY = "ready";
    private static final String USER_ID = "users_id";
    private static final String CREW_ID = "crew_id";
    public static final String STAFF_ID = "staff_id";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = CREATE_DATE)
    private Date createDate;

    @Column
    private Integer ready;

    @ManyToOne
    @JoinColumn(name = USER_ID, nullable = false)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "member"
            , joinColumns = {@JoinColumn(name = CREW_ID)}
            , inverseJoinColumns = {@JoinColumn(name = STAFF_ID)})
    private Set<Staff> members = new HashSet<>();

    public Set<Staff> getMembers() {
        return members;
    }

    public void setMembers(Set<Staff> members) {
        this.members = members;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getReady() {
        return ready;
    }

    public void setReady(Integer ready) {
        this.ready = ready;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Crew{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", ready=" + ready +
                ", user=" + user +
                ", members=");
        try {
            str.append(members);
        } catch (Exception e) {
            str.append("{"+e.getMessage()+"}");
        }
        str.append('}');
        return str.toString();
    }
}

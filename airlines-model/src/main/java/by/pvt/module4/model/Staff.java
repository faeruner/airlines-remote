package by.pvt.module4.model;


import by.pvt.module4.common.Fact;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Staff implements Serializable, Fact {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String MEMBER_TYPE_ID = "member_type_id";

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @ManyToOne
    @JoinColumn(name = MEMBER_TYPE_ID)
    private MemberType member;
    @ManyToMany(mappedBy = "members")
    private Set<Crew> crews = new HashSet<Crew>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public MemberType getMember() {
        return member;
    }

    public void setMember(MemberType member) {
        this.member = member;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Staff other = (Staff) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Set<Crew> getCrews() {
        return crews;
    }

    public void setCrews(Set<Crew> crews) {
        this.crews = crews;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", member=");
        try {
            str.append(member);
        } catch (Exception e) {
            str.append('{' + e.getMessage() + '}');
        }
        str.append(", crews=");
        try {
            str.append(crews);
        } catch (Exception e) {
            str.append('{' + e.getMessage() + '}');
        }
        str.append('}');
        return str.toString();
    }
}
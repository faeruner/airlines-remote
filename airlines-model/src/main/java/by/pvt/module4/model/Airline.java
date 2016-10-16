package by.pvt.module4.model;

import by.pvt.module4.common.Fact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Airline implements Serializable, Fact {
	public static final String ID = "id";
    public static final String NAME = "name";

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;

	public Airline() {
	}

	public Airline(String name) {
		this.name = name;
	}

	public Airline(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Airline{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}

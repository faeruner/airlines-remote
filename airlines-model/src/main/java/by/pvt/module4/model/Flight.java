package by.pvt.module4.model;


import by.pvt.module4.common.Fact;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Flight implements Serializable, Fact {

	public static final String ID = "id";
	public static final String CODE = "code";
	public static final String DEPARTURE_DATE = "departure";
	public static final String RETURN_DATE = "return_date";
	public static final String CREATE_DATE = "create_date";
	public static final String AIRPORT_ARV_ID = "airport_arv_id";
	public static final String AIRPORT_DEP_ID = "airport_dep_id";
	public static final String AIRLINE_ID = "airline_id";
	public static final String CREW_ID = "crew_id";
    private static final String USER_ID = "users_id";

    @Id
    @GeneratedValue
    private Integer id; // id

	@Column
    private String code; // code

	@Column(name = DEPARTURE_DATE)
	private Date depDate; // departure

	@Column(name = RETURN_DATE)
	private Date returnDate; // return_date

	@Column(name = CREATE_DATE)
	private Date createDate; // create_date

	@ManyToOne
    @JoinColumn(name = AIRPORT_ARV_ID)
    private Airport arrival; // airport_arv_id

	@ManyToOne
    @JoinColumn(name = AIRPORT_DEP_ID)
    private Airport departure; // airport_dep_id

	@ManyToOne
    @JoinColumn(name = AIRLINE_ID)
    private Airline airline; // airline_id

	@ManyToOne
    @JoinColumn(name = CREW_ID)
    private Crew crew; // crew_id

	@ManyToOne
    @JoinColumn(name = USER_ID)
    private User user; // users_id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Airport getArrival() {
		return arrival;
	}

	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Flight{" +
				"id=" + id +
				", code='" + code + '\'' +
				", depDate=" + depDate +
				", returnDate=" + returnDate +
				", createDate=" + createDate +
				", arrival=" + arrival +
				", departure=" + departure +
				", airline=" + airline +
				", crew=" + crew +
				", user=" + user +
				'}';
	}
}

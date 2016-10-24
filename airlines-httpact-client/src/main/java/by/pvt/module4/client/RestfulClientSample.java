package by.pvt.module4.client;

import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.CommonEntityListImpl;
import by.pvt.module4.model.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Date;

public class RestfulClientSample {
    private static final String URL_GET_ALL_CREWS = "http://localhost:8080/restful/crew/listdata";
    private static final String URL_GET_CREW_BY_ID = "http://localhost:8080/restful/crew/{id}";
    private static final String URL_CREATE_CREW = "http://localhost:8080/restful/crew/";
    private static final String URL_UPDATE_CREW = "http://localhost:8080/restful/crew/{id}";
    private static final String URL_DELETE_CREW = "http://localhost:8080/restful/crew/{id}";

    private static final String URL_GET_ALL_FLIGHTS = "http://localhost:8080/restful/flight/listdata";
    private static final String URL_GET_FLIGHT_BY_ID = "http://localhost:8080/restful/flight/{id}";
    private static final String URL_CREATE_FLIGHT = "http://localhost:8080/restful/flight/";
    private static final String URL_UPDATE_FLIGHT = "http://localhost:8080/restful/flight/{id}";
    private static final String URL_DELETE_FLIGHT = "http://localhost:8080/restful/flight/{id}";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/restful-client-app-context.xml");
        ctx.refresh();
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);

        Crew crew;
        System.out.println("Testing retrieve all crews: ");
        CommonEntityList<Crew> crews = restTemplate.getForObject(URL_GET_ALL_CREWS, CommonEntityListImpl.class);
        listEntity(crews.getEntities());
        System.out.println("");

        System.out.println("Testing retrieve а crew by id: ");
        crew = restTemplate.getForObject(URL_GET_CREW_BY_ID, Crew.class, 1);
        System.out.println(crew);
        System.out.println("");

        Staff staff = crew.getMembers().iterator().next();
        User user = crew.getUser();

        System.out.println("Testing create crew: ");
        Crew crewNew = new Crew();
        crewNew.setReady(1);
        crewNew.setCreateDate(new Date());
        crewNew.setUser(user);
        crewNew = restTemplate.postForObject(URL_CREATE_CREW, crewNew, Crew.class);
        System.out.println("Crew created success fully: " + crewNew);
        System.out.println("");

        crewNew.getMembers().add(staff);
        crewNew.setReady(0);
        System.out.println("Testing update crew by id: ");
        restTemplate.put(URL_UPDATE_CREW, crewNew, crewNew.getId());
        System.out.println("Crew update successfully: " + crewNew);
        System.out.println("");

        restTemplate.delete(URL_DELETE_CREW, crewNew.getId());
        System.out.println("Testing delete crew by id: ");
        crews = restTemplate.getForObject(URL_GET_ALL_CREWS, CommonEntityListImpl.class);
        listEntity(crews.getEntities());

////////////////////////////////////////////////////////////
        System.out.println("Testing retrieve all flights: ");
        CommonEntityList<Flight> flights = restTemplate.getForObject(URL_GET_ALL_FLIGHTS, CommonEntityListImpl.class);
        listEntity(flights.getEntities());
        System.out.println("");

        System.out.println("Testing retrieve а crew by id: ");
        Flight flight;

        flight = restTemplate.getForObject(URL_GET_FLIGHT_BY_ID, Flight.class, 1);
        System.out.println(flight);
        System.out.println("");

        Flight flightNew = new Flight();
        flightNew.setId(1);
        flightNew.setCode("dfgdgnh");
        Airline airlineNew = new Airline();
        airlineNew.setName("testAirline");
        flightNew.setAirline(airlineNew);
        Airport airportNew = new Airport();
        airportNew.setName("Test Airport");
        flightNew.setArrival(airportNew);
        flightNew = restTemplate.postForObject(URL_CREATE_FLIGHT, flightNew, Flight.class);
        System.out.println("Flight created success fully: " + flightNew);
        System.out.println("");

        flightNew.setCode(flightNew.getCode() + "suffix");

        restTemplate.put(URL_UPDATE_FLIGHT, flightNew, flightNew.getId());
        System.out.println("Flight update successfully: " + flightNew);
        System.out.println("");

        restTemplate.delete(URL_DELETE_FLIGHT, flightNew.getId());
        System.out.println("Testing delete flight by id: ");
        flights = restTemplate.getForObject(URL_GET_ALL_FLIGHTS, CommonEntityListImpl.class);
        listEntity(flights.getEntities());
    }

    private static <T> void listEntity(Collection<T> entities) {
        for (T entity : entities) {
            System.out.println(entity);
            System.out.println("");
        }
    }
}

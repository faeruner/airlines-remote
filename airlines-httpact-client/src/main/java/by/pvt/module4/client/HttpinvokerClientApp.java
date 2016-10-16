package by.pvt.module4.client;

import by.pvt.module4.model.Airline;
import by.pvt.module4.model.Crew;
import by.pvt.module4.model.User;
import by.pvt.module4.services.AirlineService;
import by.pvt.module4.services.CrewService;
import by.pvt.module4.services.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public class HttpinvokerClientApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/http-invoker-app-context.xml");
        ctx.refresh();

        CrewService crewService = ctx.getBean("remoteCrewService", CrewService.class);
        System.out.println("Finding all crews");
        List<Crew> crews = crewService.findAll();
        listEntity(crews);
        System.out.println("Finding crew with id equals 1");
        crews.clear();
        crews.add(crewService.findById(1));
        listEntity(crews);

        UserService userService = ctx.getBean("remoteUserService", UserService.class);
        System.out.println("Finding all users");
        List<User> users = userService.findAll();
        listEntity(users);
        System.out.println("Finding user with login A1");
        users = userService.findByLogin("A1");
        listEntity(users);

        AirlineService airlineService = ctx.getBean("remoteAirlineService", AirlineService.class);
        System.out.println("Finding all airlines");
        List<Airline> airlines = airlineService.findAll();
        listEntity(airlines);
        System.out.println("Finding airline with id equals 1");
        airlines.clear();
        airlines.add(airlineService.findById(1));
        listEntity(airlines);
    }


    private static <T> void listEntity(Collection<T> entities) {
        for (T entity : entities) {
            System.out.println(entity);
            System.out.println("");
        }
    }

}
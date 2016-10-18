package by.pvt.module4.client;

import by.pvt.module4.model.Airline;
import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Staff;
import by.pvt.module4.model.User;
import by.pvt.module4.services.AirlineService;
import by.pvt.module4.services.CrewService;
import by.pvt.module4.services.StaffService;
import by.pvt.module4.services.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HttpinvokerClientApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/http-invoker-app-context.xml");
        ctx.refresh();

        CrewService crewService = ctx.getBean("remoteCrewService", CrewService.class);
        System.out.println("Finding Page#1 of crews");
        Page<Crew> crews = crewService.findPage(new PageRequest(1, 3));
        System.out.println(String.format("Number: %d, Number Of Elements: %d, Size: %d, Total Elements: %d, Total Pages: %d",
                crews.getNumber(), crews.getNumberOfElements(), crews.getSize(), crews.getTotalElements(), crews.getTotalPages()));
        listEntity(crews.getContent());
        System.out.println("Finding crew with id equals 1");
        List<Crew> crew = new ArrayList<>();
        crew.add(crewService.findOne(1));
        listEntity(crew);

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
        airlines.add(airlineService.findOne(1));
        listEntity(airlines);

        StaffService staffService = ctx.getBean("remoteStaffService", StaffService.class);
        System.out.println("Finding all staff");
        List<Staff> staff = staffService.findAll();
        listEntity(staff);
        System.out.println("Finding staff with id equals 1");
        staff.clear();
        staff.add(staffService.findOne(1));
        listEntity(staff);
    }


    private static <T> void listEntity(Collection<T> entities) {
        for (T entity : entities) {
            System.out.println(entity);
            System.out.println("");
        }
    }

}
package by.pvt.module4.client;

import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Crews;
import by.pvt.module4.model.Staff;
import by.pvt.module4.model.User;
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

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/restful-client-app-context.xml");
        ctx.refresh();
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
        Crew crew;

        System.out.println("Testing retrieve all crews: ");
        Crews crews = restTemplate.getForObject(URL_GET_ALL_CREWS, Crews.class);
        listEntity(crews.getCrews());
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
        crewNew.getUser().setName("John");
        crewNew.getUser().setSurname("Doe");
        System.out.println("Testing update crew by id: ");
        restTemplate.put(URL_UPDATE_CREW, crewNew, crewNew.getId());
        System.out.println("Crew update successfully: " + crewNew);
        System.out.println("");

        restTemplate.delete(URL_DELETE_CREW, crewNew.getId());
        System.out.println("Testing delete crew by id: ");
        crews = restTemplate.getForObject(URL_GET_ALL_CREWS, Crews.class);
        listEntity(crews.getCrews());
    }

    private static <T> void listEntity(Collection<T> entities) {
        for (T entity : entities) {
            System.out.println(entity);
            System.out.println("");
        }
    }
}

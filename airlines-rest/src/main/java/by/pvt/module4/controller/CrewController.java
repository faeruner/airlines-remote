package by.pvt.module4.controller;

import by.pvt.module4.common.CommonController;
import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Crews;
import by.pvt.module4.services.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/crew")
public class CrewController extends CommonController<Crew> {

    @Autowired
    private CrewService crewService;

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Crews listData() {
        return new Crews(crewService.findAll());
    }

    @RequestMapping(value = "/pagedata", method = RequestMethod.GET)
    @ResponseBody
    public Crews pageData(@RequestParam Map<String, String> paramMap) {
        return new Crews(findPage(paramMap, crewService));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Crew findCrewOne(@PathVariable Integer id) {
        return crewService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Crew create(@RequestBody Crew crew) {
        log.info("Creating crew: " + crew);
        crewService.save(crew);
        log.info("Crew created successfully with info: " + crew);
        return crew;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Crew crew,
                       @PathVariable Integer id) {
        log.info("Updating crew: " + crew);
        crewService.save(crew);
        log.info("Crew updated successfully with info: " + crew);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        log.info("Deleting contact with id: " + id);
        Crew crew = crewService.findOne(id);
        crewService.delete(crew);
        log.info("Crew deleted successfully");
    }
}


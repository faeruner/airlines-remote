package by.pvt.module4.controller;

import by.pvt.module4.common.CommonController;
import by.pvt.module4.model.Crew;
import by.pvt.module4.services.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/crew")
public class CrewController extends CommonController<Crew> {

    @Autowired
    public CrewController(CrewService crewService) {
        super(crewService);
    }

}


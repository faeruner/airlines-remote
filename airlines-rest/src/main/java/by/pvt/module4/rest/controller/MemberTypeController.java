package by.pvt.module4.rest.controller;

import by.pvt.module4.model.MemberType;
import by.pvt.module4.model.MemberTypes;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/membertype")
public class MemberTypeController extends CommonController<MemberType, MemberTypes> {

    @Autowired
    public MemberTypeController(MemberTypeService service) {
        super(service);
    }
}

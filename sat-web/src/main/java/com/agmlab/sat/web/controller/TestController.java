package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alparslan on 09.05.2014.
 */
@Controller
@RequestMapping("/test/{id}")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String test(@PathVariable String id){
        return testService.testService(id);
    }

}

package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.TestService;
import com.agmlab.sat.web.domain.JsonTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alparslan on 12.05.2014.
 */
@Controller
public class PathTestController {

    @RequestMapping(value = "/path/{id}", method = RequestMethod.GET)
    public @ResponseBody
    JsonTest testPath(@PathVariable Integer id){
        JsonTest jsonTest = new JsonTest();
        jsonTest.setText("test hop: " + id);

        return jsonTest;
    }
}

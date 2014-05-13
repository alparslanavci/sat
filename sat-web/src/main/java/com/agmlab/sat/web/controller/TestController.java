package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alparslan on 09.05.2014.
 */
@Controller
@RequestMapping("/test")
public class TestController {
  @Autowired
  private TestService testService;

  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  String test(@PathVariable String id) {
    return testService.testService(id);
  }

}

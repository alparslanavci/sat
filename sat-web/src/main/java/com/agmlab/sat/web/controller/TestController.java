package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.TestService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alparslan on 09.05.2014.
 */
@Controller
@Api(value = "test", description = "Test API")
@RequestMapping("/test")
public class TestController {
  @Autowired
  private TestService testService;

  @ApiOperation(value = "Get Test", notes = "Returns the email of first")
  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  String test() {
    return testService.testService("1");
  }

}

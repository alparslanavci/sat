package com.agmlab.sat.web.controller;

import com.agmlab.sat.web.domain.JsonTest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alparslan on 12.05.2014.
 */
@Controller
@Api(value = "pathtest", description = "Path Test API")
public class PathTestController {

  @ApiOperation(value = "Get Path Test", notes = "hop!")
  @RequestMapping(value = "/path/{id}", method = RequestMethod.GET)
  public
  @ResponseBody
  JsonTest testPath(@PathVariable Integer id) {
    JsonTest jsonTest = new JsonTest();
    jsonTest.setText("test hop: " + id);

    return jsonTest;
  }
}

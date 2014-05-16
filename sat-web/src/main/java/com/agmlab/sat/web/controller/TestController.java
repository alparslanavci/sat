package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.TestService;
import com.agmlab.sat.web.domain.Response;
import com.agmlab.sat.web.domain.TestRequest;
import com.agmlab.sat.web.util.ResponseUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
  private Logger log = Logger.getLogger(getClass());

  @Autowired
  private TestService testService;

  @ApiOperation(value = "Get Test", notes = "Returns the email of first")
  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  Response test() {
    String email = testService.testService("1");
    return ResponseUtil.wrapSuccessful(email);
  }

  @ApiOperation(value = "Post Test", notes = "Post something")
  @RequestMapping(value = "/testpost", method = RequestMethod.POST)
  public @ResponseBody
  Response testPost(@RequestBody TestRequest test) {
    log.debug("Testing post request...");
    try {
      String text = test.getText();

      if (text.equals("error")){
        throw new Exception("There is an exception!");
      }

      String data = "Test Post:" + text;

      return ResponseUtil.wrapSuccessful(data);
    } catch (Exception e) {
      log.error("Error in testing post request: " + e.getMessage(), e);
      return ResponseUtil.wrapError(e.getMessage());
    }
  }

}

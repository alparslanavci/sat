package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sertug Kaya on 5/12/14.
 */

@Controller
@Api(value = "resetpassword", description = "Reset Password API")
@RequestMapping("/reset/{resetCode}/")
public class ResetPasswordController {
  @Autowired
  private UserService userService;

  @ApiOperation(value = "Verify Reset Code", notes = "Verifies the reset code and returns the user")
  @RequestMapping(method = RequestMethod.GET)
  public String verifyResetCode(@PathVariable String resetCode) {
//    boolean resetCodeExists = userService.isResetCodeExist(resetCode);
//    if (resetCodeExists) {
//      return "/reset";
//    }
//    return "resetCode: " + resetCode;

//    model.addAttribute("testParam", "Hobaa!!!");
    return "/reset.jsp?resetcode=" + resetCode;
  }
}

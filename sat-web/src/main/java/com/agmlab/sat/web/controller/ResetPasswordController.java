package com.agmlab.sat.web.controller;

import com.agmlab.sat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sertug Kaya on 5/12/14.
 */

@Controller
@RequestMapping("/reset/{resetCode}/")
public class ResetPasswordController {
  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.GET)
  public String verifyResetCode(@PathVariable String resetCode){
    boolean resetCodeExists = userService.isResetCodeExist(resetCode);
    if(resetCodeExists)
      return "/reset/{resetCode}/";
    return "resetCode: "+resetCode;
  }
}

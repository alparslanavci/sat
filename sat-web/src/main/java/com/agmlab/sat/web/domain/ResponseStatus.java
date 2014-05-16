package com.agmlab.sat.web.domain;

import java.io.Serializable;

/**
 * Created by alparslan on 16.05.2014.
 */
public class ResponseStatus implements Serializable{
  private int code;
  private String message;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

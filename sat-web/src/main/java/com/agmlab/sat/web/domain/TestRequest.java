package com.agmlab.sat.web.domain;

import java.io.Serializable;

/**
 * Created by alparslan on 16.05.2014.
 */
public class TestRequest implements Serializable{
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}

package com.agmlab.sat.web.domain;

import java.io.Serializable;

/**
 * Created by alparslan on 12.05.2014.
 */
public class JsonTest implements Serializable {
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}

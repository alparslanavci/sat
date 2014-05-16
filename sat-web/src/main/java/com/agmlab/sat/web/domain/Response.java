package com.agmlab.sat.web.domain;

import java.io.Serializable;

/**
 * Created by alparslan on 15.05.2014.
 */
public class Response implements Serializable {
  private ResponseStatus responseStatus;
  private boolean success;
  private long duration;
  private Serializable data;

  public ResponseStatus getResponseStatus() {
    return responseStatus;
  }

  public void setStatus(ResponseStatus responseStatus) {
    this.responseStatus = responseStatus;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }

  public Serializable getData() {
    return data;
  }

  public void setData(Serializable data) {
    this.data = data;
  }
}

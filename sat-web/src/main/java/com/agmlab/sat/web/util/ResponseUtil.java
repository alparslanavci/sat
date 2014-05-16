package com.agmlab.sat.web.util;

import com.agmlab.sat.web.domain.Response;
import com.agmlab.sat.web.domain.ResponseStatus;

import java.io.Serializable;

/**
 * Created by alparslan on 16.05.2014.
 */
public class ResponseUtil {
  public enum StatusCode{
    SUCCESSFUL(500), ERROR(800);

    private int code;

    StatusCode(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

  }

  public final static String GENERAL_SUCCESS_MESSAGE = "Successfully completed.";

  /**
   * Generic Response wrapper method.
   *
   * @param data to be wrapped
   * @param success true if successfully completed
   * @param statusCode corresponding StatusCode
   * @param statusMessage to be set
   * @return wrapped Response object
   */
  public static Response wrap(Serializable data, boolean success, StatusCode statusCode,
      String statusMessage) {
    Response response = new Response();
    ResponseStatus status = new ResponseStatus();
    status.setCode(statusCode.getCode());
    status.setMessage(statusMessage);
    response.setStatus(status);
    response.setSuccess(success);
    response.setData(data);
    return response;
  }

  /**
   * Use this method to wrap data into error Response with a provided message.
   * @param statusMessage to be set
   * @return wrapped Response object
   */
  public static Response wrapError(String statusMessage) {
    return wrap(null, false, StatusCode.ERROR, statusMessage);
  }

  /**
   * Use this method to wrap data into succesfull Response with generic success message.
   * @param data to be wrapped
   * @return wrapped Response object
   */
  public static Response wrapSuccessful(Serializable data) {
    return wrap(data, true, StatusCode.SUCCESSFUL,
        GENERAL_SUCCESS_MESSAGE);
  }

  /**
   * Use this method to wrap data into succesfull Response with a provided message.
   * @param data to be wrapped
   * @param statusMessage to be set
   * @return wrapped Response object
   */
  public static Response wrapSuccessful(Serializable data, String statusMessage) {
    return wrap(data, true, StatusCode.SUCCESSFUL,
        statusMessage);
  }
}

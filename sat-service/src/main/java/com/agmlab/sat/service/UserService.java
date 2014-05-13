package com.agmlab.sat.service;

import com.agmlab.sat.persist.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * Created by Sertug Kaya on 5/12/14.
 */
@Service
public class UserService {
  private UserDao userDao;

  public boolean isResetCodeExist(String resetCode) {
    return userDao.isResetCodeExist(resetCode);
  }
}

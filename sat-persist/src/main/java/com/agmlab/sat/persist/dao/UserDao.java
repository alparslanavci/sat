package com.agmlab.sat.persist.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sertug Kaya on 5/12/14.
 */
@Repository
public class UserDao extends AbstractBaseDao {
  public boolean isResetCodeExist(String resetCode) {
    MapSqlParameterSource paramSource = new MapSqlParameterSource();
    paramSource.addValue("resetCode",resetCode);
    List<Integer> validateResetCodes = getNamedParameterJdbcTemplate().queryForList(getSql("validateResetCode"), paramSource, Integer.class);
    return validateResetCodes.size() > 0;
  }
}

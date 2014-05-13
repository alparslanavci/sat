package com.agmlab.sat.persist.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * Created by alparslan on 09.05.2014.
 */
@Repository
public class TestDao extends AbstractBaseDao {
  public String test(String id) {
    MapSqlParameterSource paramSource = new MapSqlParameterSource();
    paramSource.addValue("id", id);
    return getNamedParameterJdbcTemplate()
        .queryForObject(getSql("testSql"), paramSource, String.class);
  }

  public int testInsert(String test) {
    MapSqlParameterSource paramSource = new MapSqlParameterSource();
    paramSource.addValue("testParam", test);
    return getNamedParameterJdbcTemplate()
        .update(getSql("testInsert"), paramSource);
  }
}

package com.agmlab.sat.persist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Properties;

/**
 * Created by alparslan on 09.05.2014.
 */
@Repository
public class AbstractBaseDao {

    @Autowired
    private Properties sqlProperties;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public String getSql(String key) {
        return sqlProperties.getProperty(key);
    }
}

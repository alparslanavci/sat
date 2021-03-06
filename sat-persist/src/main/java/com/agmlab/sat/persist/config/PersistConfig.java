package com.agmlab.sat.persist.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by alparslan.
 */
@Configuration
@ComponentScan("com.agmlab.sat.persist")
public class PersistConfig {

  @Bean
  Properties sqlProperties() throws IOException {
    PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
    PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
    factoryBean.setLocations(patternResolver.getResources("sql/*.properties"));
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  @Bean
  MysqlDataSource dataSource() {
    MysqlDataSource dataSource = new MysqlDataSource();
    dataSource.setURL(
        "jdbc:mysql://localhost:3306/sat?useUnicode=true&amp;characterEncoding=utf8");
    dataSource.setUser("root");
    dataSource.setPassword("123456");
    return dataSource;
  }

  @Bean
  NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
    return new NamedParameterJdbcTemplate(dataSource());
  }

}

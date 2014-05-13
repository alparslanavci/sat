package com.agmlab.sat.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by alparslan on 09.05.2014.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.agmlab.sat.web.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**")
        .addResourceLocations("/WEB-INF/resources/");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    registry.addInterceptor(localeChangeInterceptor);
  }

  @Bean
  public LocaleResolver localeResolver() {

    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
    cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("tr"));
    return cookieLocaleResolver;
  }

  @Bean
  public MessageSource messageSource() {

    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath:messages/messages",
        "classpath:messages/validation");
    // if true, the key of the message will be displayed if the key is not
    // found, instead of throwing a NoSuchMessageException
    messageSource.setUseCodeAsDefaultMessage(true);
    messageSource.setDefaultEncoding("UTF-8");
    // # -1 : never reload, 0 always reload
    messageSource.setCacheSeconds(0);
    return messageSource;
  }

  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

}

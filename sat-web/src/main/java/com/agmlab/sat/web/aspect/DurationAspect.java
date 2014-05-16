package com.agmlab.sat.web.aspect;

import com.agmlab.sat.web.domain.Response;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by alparslan on 16.05.2014.
 */
@Component
@Aspect
public class DurationAspect {
  private Logger log = Logger.getLogger(getClass());

  @Around("execution(* com.agmlab.sat.web.controller.*.*(..))")
  public Object aroundAllControllers(ProceedingJoinPoint proceedingJoinPoint)
      throws Throwable {
    log.debug(
        "Starting [" + proceedingJoinPoint.getSignature().getName() + "]...");
    long start = System.currentTimeMillis();
    Object proceed = proceedingJoinPoint.proceed();
    long end = System.currentTimeMillis();
    long duration = end - start;
    if (proceed instanceof Response){
      Response response = (Response) proceed;
      response.setDuration(duration);
    }
    log.debug(
        "Completed [" + proceedingJoinPoint.getSignature().getName() + "] in "
            + duration + "ms");
    return proceed;
  }

}

package com.learn.tavant.config;

import com.learn.tavant.exceptionHandler.InvalidAuthTokenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;



/*
    Handler Interceptor are designed for Handing request response or
    for authentication, auth ect.
    three main methods are there --
    preHandle --> runs before controller runs
    postHandle --> runs before sending response
    afterCompletion --> runs after completing api call . can be used to clear garbage
*/


@Component
public class ApiLogInterceptor implements HandlerInterceptor {


    public static final Logger LOGGER = LoggerFactory.getLogger(ApiLogInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalDateTime requestDateTime = LocalDateTime.now();
        String requestMethod = request.getMethod();
        StringBuffer requestUrl = request.getRequestURL();
        Instant requestTime = Instant.now();
        request.setAttribute("requestTime", requestTime);
        LOGGER.info(String.format("=== Request Time --> %s === method --> %s === url  -->  %s", requestDateTime, requestMethod, requestUrl));


//        if ("POST".equalsIgnoreCase(request.getMethod()))
//        {
//            if (DispatcherType.ASYNC.equals(request.getDispatcherType())){
//                return true;
//            }
//
//            System.out.println(request.getRequestURL());
//            InputStream res = request.getInputStream();
//            String text = new BufferedReader(new InputStreamReader(res, StandardCharsets.UTF_8))
//                    .lines()
//                    .collect(Collectors.joining("\n"));
//            System.out.println(text);
//
//        }
        String token = request.getHeader("token");
        if(! "anil-yadav".equalsIgnoreCase(token)){
            LOGGER.error("=== Request token is missing or invalid, try again with token");
            throw new InvalidAuthTokenException(HttpStatus.resolve(401), "Auth token is not valid");
        }
        LOGGER.info("=== token verified");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{
        LocalDateTime responseDateTime = LocalDateTime.now();
        StringBuffer responseUrl = request.getRequestURL();
        Duration timeElapsed = Duration.between(Instant.now(), (Instant) request.getAttribute("requestTime"));

        LOGGER.info(String.format("=== Response Time --> %s === duration --> %s", responseDateTime,  timeElapsed));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {

    }

}

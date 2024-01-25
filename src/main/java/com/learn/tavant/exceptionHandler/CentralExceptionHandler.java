package com.learn.tavant.exceptionHandler;

import com.learn.tavant.model.common.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CentralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidAuthTokenException.class)
    protected ResponseEntity<ResponseModel> invalidToken(InvalidAuthTokenException ex){
        return new ResponseEntity<>(new ResponseModel(ex.message, ex.status), ex.status);
    }

    @ExceptionHandler(NoDataFoundException.class)
    protected ResponseEntity<ResponseModel> noDataFoundHandler(NoDataFoundException ex){
        return new ResponseEntity<>(new ResponseModel(ex.message, ex.status), ex.status);
    }
}

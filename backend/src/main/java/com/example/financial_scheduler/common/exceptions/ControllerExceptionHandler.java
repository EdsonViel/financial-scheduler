package com.example.financial_scheduler.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.financial_scheduler.common.message.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler({RuleException.class})
    public ResponseEntity<ErrorMessage> exceptionHandler(RuleException e){
    	e.printStackTrace();
        return new ResponseEntity<> (new ErrorMessage(e.getMessage(), e.getStatus().toString()), e.getStatus()) ;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage methodArgumentNotValidException(MethodArgumentNotValidException ex){
    	ex.printStackTrace();
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        String error;
        if(errors.size() > 1){
            error = "Os campos " + String.join(",", errors) + " são obrigatórios";
        }else {
            error = "O campo " + errors.stream().findFirst().get() + " é obrigatório";
        }
        return new ErrorMessage(error, HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage runTimeException(RuntimeException re){
        re.printStackTrace();
        return new ErrorMessage(re.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
    
}

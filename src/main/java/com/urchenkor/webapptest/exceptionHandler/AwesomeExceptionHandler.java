/*
package com.urchenkor.webapptest.exceptionHandler;

import com.urchenkor.webapptest.exceptionHandler.exceptions.NoSuchStatusException;
import com.urchenkor.webapptest.exceptionHandler.exceptions.ThereIsNoSuchPersonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchStatusException.class)
    protected ResponseEntity<AwesomeException> handleNoSuchStatusException() {
        return new ResponseEntity<>(new AwesomeException("Не существует такого статуса"),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNoSuchPersonException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchPersonException() {
        return new ResponseEntity<>(new AwesomeException("There is no such person"),
                HttpStatus.NOT_FOUND);
    }

    private static class AwesomeException {
        private String message;

        public AwesomeException(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
*/

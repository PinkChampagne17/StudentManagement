package io.pinkchampagne17.exception;

import io.pinkchampagne17.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(Exception e) {

        System.out.println(e.toString() + " " + e.getMessage());

        if (e instanceof CustomException) {
            ErrorMessage errorMessage = ((CustomException) e).getErrorMessage();
            int status = errorMessage.getStatus();

            return ResponseEntity.status(status).body(errorMessage);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage());
    }

}

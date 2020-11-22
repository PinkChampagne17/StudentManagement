package io.pinkchampagne17.exception;

import io.pinkchampagne17.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class BindingResultHasErrorException extends CustomException {

    public BindingResultHasErrorException(BindingResult bindingResult) {
        super(new ErrorMessage() {
            {
                if (bindingResult.hasErrors()) {
                    setMessage(bindingResult.getAllErrors().get(0).getDefaultMessage());
                } else {
                    setMessage("传入数据不符合要求");
                }
                setStatus(HttpStatus.BAD_REQUEST.value());
            }
        });

    }
}

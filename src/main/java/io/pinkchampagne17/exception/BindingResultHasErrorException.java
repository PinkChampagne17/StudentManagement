package io.pinkchampagne17.exception;

import org.springframework.validation.BindingResult;

public class BindingResultHasErrorException extends Exception {

    private String message = "传入数据不符合要求";

    public BindingResultHasErrorException(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            this.message = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}

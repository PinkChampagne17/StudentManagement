package io.pinkchampagne17.exception;

import io.pinkchampagne17.entity.ErrorMessage;

/**
 * 自定义Exception。
 */
public class CustomException extends Exception {
    /**
     * 用于返回的ErrorMessage。
     */
    private final ErrorMessage errorMessage;

    public CustomException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage.getMessage();
    }
}

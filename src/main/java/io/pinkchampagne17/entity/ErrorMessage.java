package io.pinkchampagne17.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {
    private int status;
    private int code;
    private String message;
    private String traceId;
    private String moreInfo;

    public ErrorMessage() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.code = 0;
        this.message = "Unknown Error.";
    }
}

package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoSuchQuestionException extends RuntimeException {
    public NoSuchQuestionException() {
    }

    public NoSuchQuestionException(String message) {
        super(message);
    }

    public NoSuchQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchQuestionException(Throwable cause) {
        super(cause);
    }

    public NoSuchQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

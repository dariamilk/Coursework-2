package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST)
public class DoNotHaveEnoughQuestionsException extends RuntimeException {
    public DoNotHaveEnoughQuestionsException() {
    }

    public DoNotHaveEnoughQuestionsException(String message) {
        super(message);
    }

    public DoNotHaveEnoughQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoNotHaveEnoughQuestionsException(Throwable cause) {
        super(cause);
    }

    public DoNotHaveEnoughQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

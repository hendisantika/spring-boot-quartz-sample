package id.my.hendisantika.quartzsample.exception.base;

import id.my.hendisantika.quartzsample.exception.BadRequestException;
import id.my.hendisantika.quartzsample.exception.DataNotFoundException;
import id.my.hendisantika.quartzsample.exception.DuplicateException;
import id.my.hendisantika.quartzsample.exception.ForbiddenException;
import id.my.hendisantika.quartzsample.exception.TooManyRequestsException;
import id.my.hendisantika.quartzsample.exception.UnauthorizedException;
import id.my.hendisantika.quartzsample.exception.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.40
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestControllerAdvice
public class BaseControllerAdvice {

    public static final Timestamp TIMESTAMP = new Timestamp(System.currentTimeMillis());

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noHandlerFoundException(NoHandlerFoundException ex) {
        log.debug(ex.getMessage(), ex.getCause());
        return new ErrorResponse(
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                "No resource found for your request. Please verify you request",
                TIMESTAMP);
    }

    @ExceptionHandler({DataNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse dataNotFoundException(Exception ex) {
        log.debug(ex.getMessage(), ex.getCause());
        return new ErrorResponse(
                String.valueOf(HttpStatus.NOT_FOUND.value()), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler({BadRequestException.class, DuplicateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequestException(Exception ex) {
        return new ErrorResponse(
                String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleUnauthorizedException(Exception ex) {
        return new ErrorResponse(
                String.valueOf(HttpStatus.UNAUTHORIZED.value()), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler({ForbiddenException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleForbiddenException(Exception ex) {
        return new ErrorResponse(
                String.valueOf(HttpStatus.FORBIDDEN.value()), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler({TooManyRequestsException.class})
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public ErrorResponse handleTooManyRequestsException(Exception ex) {
        return new ErrorResponse(
                String.valueOf(HttpStatus.TOO_MANY_REQUESTS.value()), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse notSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.debug(ex.getMessage(), ex.getCause());
        return new ErrorResponse(
                String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()),
                "Method Not Allowed. Please verify you request",
                TIMESTAMP);
    }

    @ExceptionHandler({Exception.class, ServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllExceptions(Exception ex) {
        log.error(ex.getMessage(), ex.getLocalizedMessage());
        return new ErrorResponse(
                String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationExceptionHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ErrorResponse(
                String.valueOf(HttpStatus.BAD_REQUEST.value()), errors.toString(), TIMESTAMP);
    }
}

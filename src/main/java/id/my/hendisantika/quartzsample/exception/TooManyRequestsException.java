package id.my.hendisantika.quartzsample.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.38
 * To change this template use File | Settings | File Templates.
 */

import id.my.hendisantika.quartzsample.exception.base.ServiceException;

/**
 * trigger for too many requests exception
 */
public class TooManyRequestsException extends ServiceException {

    public TooManyRequestsException() {
        super();
    }

    public TooManyRequestsException(String message) {
        super(message);
    }

    public TooManyRequestsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

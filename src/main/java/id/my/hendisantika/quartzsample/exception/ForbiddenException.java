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
 * trigger for forbidden exception
 */
public class ForbiddenException extends ServiceException {

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}


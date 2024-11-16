package id.my.hendisantika.quartzsample.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.39
 * To change this template use File | Settings | File Templates.
 */

import id.my.hendisantika.quartzsample.exception.base.ServiceException;

/**
 * trigger for unauthorized exception
 */
public class UnauthorizedException extends ServiceException {

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

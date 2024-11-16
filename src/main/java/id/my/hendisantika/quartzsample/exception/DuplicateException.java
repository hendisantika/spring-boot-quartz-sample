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
 * trigger for duplicate exception
 */
public class DuplicateException extends ServiceException {

    public DuplicateException() {
        super();
    }

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

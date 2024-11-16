package id.my.hendisantika.quartzsample.job;

import io.micrometer.common.lang.NonNullApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.32
 * To change this template use File | Settings | File Templates.
 */
@Component
@NonNullApi
@Slf4j
@Setter
@DisallowConcurrentExecution
public class Job extends QuartzJobBean {

    private MailService mailService;

    @Autowired
    public void autowire(final MailService mailService) {
        this.mailService = mailService;
    }
}

package id.my.hendisantika.quartzsample.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.34
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
@Slf4j
@Component("jobScheduler")
public class JobScheduler {
    private final SchedulerFactoryBean schedulerFactoryBean;
}

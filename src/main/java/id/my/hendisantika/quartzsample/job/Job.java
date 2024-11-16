package id.my.hendisantika.quartzsample.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.quartzsample.model.dto.JobDTO;
import id.my.hendisantika.quartzsample.service.MailService;
import io.micrometer.common.lang.NonNullApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
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

    @Override
    public void executeInternal(final JobExecutionContext context) {
        log.info("Job execute {}", context.getJobDetail().getKey().getName());
        JobDTO jobDTO = null;
        try {
            jobDTO =
                    new ObjectMapper()
                            .readValue(context.getMergedJobDataMap().getString("jobDTO"), JobDTO.class);
        } catch (JsonProcessingException e) {
            log.info(e.toString());
        }
        mailService.send(jobDTO.getFrom(), jobDTO.getTo(), jobDTO.getSubject(), jobDTO.getBody());
        if (false) {
            this.unScheduleJob(context);
        }
    }
}

package id.my.hendisantika.quartzsample.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.quartzsample.job.Job;
import id.my.hendisantika.quartzsample.model.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static org.quartz.CalendarIntervalScheduleBuilder.calendarIntervalSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

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

    public String execute(JobDTO jobDTO) throws JsonProcessingException {
        String uuid = UUID.randomUUID().toString();
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.start();

            JobDetail job =
                    newJob(Job.class)
                            .withIdentity(uuid, "GROUP1")
                            .usingJobData(
                                    new JobDataMap(Map.of("jobDTO", new ObjectMapper().writeValueAsString(jobDTO))))
                            .build();

            //            JobDetail job =
            //                    newJob(Job.class)
            //                            .withIdentity(uuid, "GROUP1")
            //                            .usingJobData("from", jobDTO.getTo())
            //                            .usingJobData("to", jobDTO.getTo())
            //                            .usingJobData("subject", jobDTO.getSubject())
            //                            .usingJobData("body", jobDTO.getBody())
            //                            .build();
            long timeAdj = 24 * 60 * 60 * 1000;
            Trigger trigger =
                    newTrigger()
                            .forJob(job)
                            .withIdentity(uuid, "GROUP1")
                            .startAt(new Date())
                            .withSchedule(calendarIntervalSchedule().withIntervalInMinutes(1))
                            .endAt(new Date(System.currentTimeMillis() + timeAdj))
                            .build();

            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException exception) {
            log.error("Error while scheduling mail job", exception);
        }
        return uuid;
    }
}

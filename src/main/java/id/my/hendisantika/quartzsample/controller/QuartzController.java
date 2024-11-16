package id.my.hendisantika.quartzsample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.my.hendisantika.quartzsample.model.dto.JobDTO;
import id.my.hendisantika.quartzsample.schedule.JobScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 11.29
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class QuartzController {

    private final JobScheduler jobScheduler;

    @GetMapping("/v1/quartz")
    public ResponseEntity<String> quartz() throws JsonProcessingException {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setFrom("hendisantika@yahoo.co.id");
        jobDTO.setTo("hendisantika@yahoo.co.id");
        jobDTO.setSubject("Hello - Testing");
        jobDTO.setBody("Hello from Spring Boot");
        jobScheduler.execute(jobDTO);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}

package id.my.hendisantika.quartzsample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.29
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
public class JavaApp {

    public static void main(String[] args) throws JsonProcessingException {
        JobDTO jobDTO = JobDTO.builder().from("from").to("to").subject("subject").body("body").build();

        Map<String, Object> map = Map.of("key1", new ObjectMapper().writeValueAsString(jobDTO));

        log.info(map.toString());

        JobDTO newJobDTO = new ObjectMapper().readValue(map.get("key1").toString(), JobDTO.class);

        log.info(newJobDTO.toString());
    }
}

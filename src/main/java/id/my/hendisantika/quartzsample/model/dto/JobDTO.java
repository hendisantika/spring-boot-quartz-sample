package id.my.hendisantika.quartzsample.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.30
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDTO {
    private String from;
    private String to;
    private String subject;
    private String body;
}

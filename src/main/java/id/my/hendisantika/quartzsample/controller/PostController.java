package id.my.hendisantika.quartzsample.controller;

import id.my.hendisantika.quartzsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 11.13
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PostController {

    private final PostService service;
}

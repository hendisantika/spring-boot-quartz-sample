package id.my.hendisantika.quartzsample.controller;

import id.my.hendisantika.quartzsample.model.entity.Author;
import id.my.hendisantika.quartzsample.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 11.12
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @GetMapping("/v1/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> list = service.getAllAuthors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/v1/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Author entity = service.getById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}

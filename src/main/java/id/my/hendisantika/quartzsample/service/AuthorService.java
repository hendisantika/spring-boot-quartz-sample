package id.my.hendisantika.quartzsample.service;

import id.my.hendisantika.quartzsample.exception.BadRequestException;
import id.my.hendisantika.quartzsample.exception.DataNotFoundException;
import id.my.hendisantika.quartzsample.model.entity.Author;
import id.my.hendisantika.quartzsample.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.35
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        List<Author> authorList = authorRepository.findAll();
        return authorList;
    }

    public Author getById(Long id) {
        return authorRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new DataNotFoundException(
                                        MessageFormat.format("Author id {0} not found", String.valueOf(id))));
    }

    public Author createOrUpdate(Author authorRequest) {
        Optional<Author> existingAuthor = authorRepository.findById(authorRequest.getId());

        if (existingAuthor.isPresent()) {
            Author authorUpdate = existingAuthor.get();

            authorUpdate.setName(authorRequest.getName());

            return authorRepository.save(authorUpdate);
        } else {
            return authorRepository.save(authorRequest);
        }
    }

    public void deleteById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            authorRepository.deleteById(id);
        } else {
            throw new BadRequestException("Delete error, please check ID and try again");
        }
    }
}

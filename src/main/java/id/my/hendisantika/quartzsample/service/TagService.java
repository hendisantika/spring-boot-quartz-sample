package id.my.hendisantika.quartzsample.service;

import id.my.hendisantika.quartzsample.exception.DataNotFoundException;
import id.my.hendisantika.quartzsample.model.entity.Tag;
import id.my.hendisantika.quartzsample.repository.TagRepository;
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
 * Time: 10.59
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        return tagList;
    }

    public Tag getById(Long id) {
        return tagRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new DataNotFoundException(
                                        MessageFormat.format("Tag id {0} not found", String.valueOf(id))));
    }

    public Tag createOrUpdate(Tag tagRequest) {
        Optional<Tag> existingTag = tagRepository.findById(tagRequest.getId());

        if (existingTag.isPresent()) {
            Tag tagUpdate = existingTag.get();

            tagUpdate.setName(tagRequest.getName());

            return tagRepository.save(tagUpdate);
        } else {
            return tagRepository.save(tagRequest);
        }
    }

}

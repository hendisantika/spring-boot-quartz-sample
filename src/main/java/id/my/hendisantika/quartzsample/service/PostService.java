package id.my.hendisantika.quartzsample.service;

import id.my.hendisantika.quartzsample.model.entity.Post;
import id.my.hendisantika.quartzsample.repository.AuthorRepository;
import id.my.hendisantika.quartzsample.repository.PostRepository;
import id.my.hendisantika.quartzsample.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/11/24
 * Time: 10.57
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final ModelMapper modelMapper;

    private final PostRepository postRepository;

    private final AuthorRepository authorRepository;

    private final TagRepository tagRepository;

    @Cacheable(value = "posts")
    public List<Post> getAllPosts(String title) {
        List<Post> postList;
        if (title == null) {
            postList = postRepository.findAll();
        } else {
            postList = postRepository.findByTitleContaining(title);
        }
        return postList;
    }
}

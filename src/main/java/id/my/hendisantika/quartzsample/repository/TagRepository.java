package id.my.hendisantika.quartzsample.repository;

import id.my.hendisantika.quartzsample.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}

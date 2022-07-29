package templates;

import com.example.fashionblogapp.Entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}

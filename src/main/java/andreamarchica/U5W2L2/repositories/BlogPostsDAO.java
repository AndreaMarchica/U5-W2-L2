package andreamarchica.U5W2L2.repositories;

import andreamarchica.U5W2L2.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostsDAO extends JpaRepository<BlogPost, Integer> {

}

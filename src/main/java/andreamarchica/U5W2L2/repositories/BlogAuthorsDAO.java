package andreamarchica.U5W2L2.repositories;

import andreamarchica.U5W2L2.entities.BlogAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogAuthorsDAO extends JpaRepository<BlogAuthor, Integer> {
}

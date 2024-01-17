package andreamarchica.U5W2L2.services;

import andreamarchica.U5W2L2.entities.BlogAuthor;
import andreamarchica.U5W2L2.entities.BlogPost;
import andreamarchica.U5W2L2.exceptions.NotFoundException;
import andreamarchica.U5W2L2.repositories.BlogAuthorsDAO;
import andreamarchica.U5W2L2.repositories.BlogPostsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostsService {
    @Autowired
    private BlogPostsDAO blogPostsDAO;
    @Autowired
    private BlogAuthorsDAO blogAuthorsDAO;

    public List<BlogPost> getBlogPosts() {
        return blogPostsDAO.findAll();
    }
    public BlogPost save(BlogPost body){
        BlogAuthor blogAuthor = body.getBlogAuthor();
        if(blogAuthor != null) {
            blogAuthor = blogAuthorsDAO.save(blogAuthor);
            body.setBlogAuthor(blogAuthor);
        }
        return blogPostsDAO.save(body);
    }
    public BlogPost findById(int id) {
    return blogPostsDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void findByIdAndDelete(int id) {
    BlogPost found =this.findById(id);
    blogPostsDAO.delete(found);
    }
    public BlogPost findByIdAndUpdate(int id, BlogPost body) {
        BlogPost found = this.findById(id);
                found.setCategory(body.getCategory());
                found.setCover(body.getCover());
                found.setContent(body.getContent());
                found.setTitle(body.getTitle());
                found.setReadingTime(body.getReadingTime());
                return  blogPostsDAO.save(found);
    }

}


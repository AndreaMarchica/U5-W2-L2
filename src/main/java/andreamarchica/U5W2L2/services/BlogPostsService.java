package andreamarchica.U5W2L2.services;

import andreamarchica.U5W2L2.entities.BlogPost;
import andreamarchica.U5W2L2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPosts = new ArrayList<>();
    public List<BlogPost> getBlogPosts() {
        return this.blogPosts;
    }
    public BlogPost save(BlogPost body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.blogPosts.add(body);
        return body;
    }
    public BlogPost findById(int id) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                found = blogPost;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
    public void findByIdAndDelete(int id) {
        Iterator<BlogPost> iterator = this.blogPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
    public BlogPost findByIdAndUpdate(int id, BlogPost body) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                found = blogPost;
                found.setId(id);
                found.setCategory(body.getCategory());
                found.setCover(body.getCover());
                found.setContent(body.getContent());
                found.setTitle(body.getTitle());
                found.setReadingTime(body.getReadingTime());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}


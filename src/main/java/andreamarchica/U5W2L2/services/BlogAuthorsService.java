package andreamarchica.U5W2L2.services;

import andreamarchica.U5W2L2.entities.BlogAuthor;
import andreamarchica.U5W2L2.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogAuthorsService {

    public List<BlogAuthor> blogAuthors = new ArrayList<>();
    public List<BlogAuthor> getBlogAuthors() {
        return this.blogAuthors;
    }
    public BlogAuthor save(BlogAuthor body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.blogAuthors.add(body);
        return body;
    }
    public BlogAuthor findById(int id) {
        BlogAuthor found = null;
        for (BlogAuthor blogPost : this.blogAuthors) {
            if (blogPost.getId() == id) {
                found = blogPost;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
    public void findByIdAndDelete(int id) {
        Iterator<BlogAuthor> iterator = this.blogAuthors.iterator();
        while (iterator.hasNext()) {
            BlogAuthor current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
    public BlogAuthor findByIdAndUpdate(int id, BlogAuthor body) {
        BlogAuthor found = null;
        for (BlogAuthor blogPost : this.blogAuthors) {
            if (blogPost.getId() == id) {
                found = blogPost;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setAvatar(body.getAvatar());
                found.setEmail(body.getEmail());
                found.setDateOfBirth(body.getDateOfBirth());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}

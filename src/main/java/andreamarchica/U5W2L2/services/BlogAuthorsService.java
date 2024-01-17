package andreamarchica.U5W2L2.services;

import andreamarchica.U5W2L2.entities.BlogAuthor;
import andreamarchica.U5W2L2.exceptions.NotFoundException;
import andreamarchica.U5W2L2.repositories.BlogAuthorsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogAuthorsService {
    @Autowired
    private BlogAuthorsDAO blogAuthorsDAO;

    public List<BlogAuthor> getBlogAuthors() {
        return blogAuthorsDAO.findAll();
    }
    public BlogAuthor save(BlogAuthor body){
        return blogAuthorsDAO.save(body);
    }
    public BlogAuthor findById(int id) {
        return blogAuthorsDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void findByIdAndDelete(int id) {
        BlogAuthor found = this.findById(id);
        blogAuthorsDAO.delete(found);
    }
    public BlogAuthor findByIdAndUpdate(int id, BlogAuthor body) {
                BlogAuthor found = this.findById(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setAvatar(body.getAvatar());
                found.setEmail(body.getEmail());
                found.setDateOfBirth(body.getDateOfBirth());
                return blogAuthorsDAO.save(found);
            }
}

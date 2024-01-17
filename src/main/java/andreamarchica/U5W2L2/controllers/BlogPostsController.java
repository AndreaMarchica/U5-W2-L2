package andreamarchica.U5W2L2.controllers;

import andreamarchica.U5W2L2.entities.BlogAuthor;
import andreamarchica.U5W2L2.entities.BlogPost;
import andreamarchica.U5W2L2.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;
    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return blogPostsService.getBlogPosts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public BlogPost saveUser(@RequestBody BlogPost body) {
        return blogPostsService.save(body);
    }
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return blogPostsService.findById(id);
    }
    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
        return this.blogPostsService.findByIdAndUpdate(id, body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable int id) {
        this.blogPostsService.findByIdAndDelete(id);
    }
}

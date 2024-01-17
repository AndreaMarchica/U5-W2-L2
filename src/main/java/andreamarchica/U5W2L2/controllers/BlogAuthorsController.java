package andreamarchica.U5W2L2.controllers;

import andreamarchica.U5W2L2.entities.BlogAuthor;
import andreamarchica.U5W2L2.services.BlogAuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class BlogAuthorsController {
    @Autowired
    private BlogAuthorsService blogAuthorsService;

    @GetMapping
    public List<BlogAuthor> getBlogAuthors() {
        return blogAuthorsService.getBlogAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public BlogAuthor saveUser(@RequestBody BlogAuthor body) {
        return blogAuthorsService.save(body);
    }

    @GetMapping("/{id}")
    public BlogAuthor findById(@PathVariable int id) {
        return blogAuthorsService.findById(id);
    }

    @PutMapping("/{id}")
    public BlogAuthor findByAndUpdate(@PathVariable int id, @RequestBody BlogAuthor body) {
        return this.blogAuthorsService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable int id) {
        this.blogAuthorsService.findByIdAndDelete(id);
    }
}

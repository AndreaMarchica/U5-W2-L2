package andreamarchica.U5W2L2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "posts")
@Getter
@Setter
/*@ToString*/
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private BlogAuthor blogAuthor;

    public BlogPost() {
    }

    public BlogPost(String category, String title, String cover, String content, int readingTime, String blogAuthorId) {
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.readingTime = readingTime;
        this.blogAuthor = new BlogAuthor(blogAuthorId);
    }
}

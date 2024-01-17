package andreamarchica.U5W2L2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
@Getter
@Setter
/*@ToString*/
public class BlogAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String avatar;
    @OneToMany(mappedBy = "blogAuthor")
    private List<BlogPost> blogPostList = new ArrayList<>();

    public BlogAuthor() {
    }

    public BlogAuthor (String blogAuthorId){
    }
}

package andreamarchica.U5W2L2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogPost {
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}

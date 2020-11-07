package pl.sda.spring_start.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String title;
    @Type(type = "text")    // typ w DB longtext
    private String content;
    private LocalDateTime dateAdded;
    private Category category;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private User author;

    public Post(String title, String content, LocalDateTime dateAdded, Category category, User author) {
        this.title = title;
        this.content = content;
        this.dateAdded = dateAdded;
        this.category = category;
        this.author = author;
    }
}

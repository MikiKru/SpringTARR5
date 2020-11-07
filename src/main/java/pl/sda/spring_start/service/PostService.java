package pl.sda.spring_start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring_start.model.Category;
import pl.sda.spring_start.model.Post;
import pl.sda.spring_start.model.User;
import pl.sda.spring_start.repository.PostRepository;

import java.time.LocalDateTime;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public void addPost(String title, String content, Category category, User author){
        postRepository.save(new Post(title,content, LocalDateTime.now(), category, author));
    }
}

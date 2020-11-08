package pl.sda.spring_start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.spring_start.model.Category;
import pl.sda.spring_start.model.Post;
import pl.sda.spring_start.model.User;
import pl.sda.spring_start.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public void addPost(String title, String content, Category category, User author){
        postRepository.save(new Post(title,content, LocalDateTime.now(), category, author));
    }
    public List<Post> getAllPosts(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "dateAdded"));
    }
    public List<Post> getPostsByCategory(Category category){
        return postRepository.findAllByCategory(category, Sort.by(Sort.Direction.DESC, "dateAdded"));
    }
    public List<Post> getPostsByCategoryAndAuthor(Category category, User author){
        return postRepository.findAllByCategoryAndAuthor(category,author,Sort.by(Sort.Direction.DESC, "dateAdded"));
    }
    public List<Post> getPostsByTitleLikeOrContentLike(String keyWord){
        return postRepository.findAllByTitleLikeOrContentLike("%"+keyWord+"%", "%"+keyWord+"%");
    }
    public String getPostsStats(){
        String output = "";
        // IT : 3
        // DS : 1
        for(Category category : postRepository.postStatistics().keySet()){
            output += category.getCategoryName() + " : " + postRepository.postStatistics().get(category) + "\n";
        }
        return output;
    }

}

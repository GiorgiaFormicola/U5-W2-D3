package GiorgiaFormicola.U5_W2_D3.services;

import GiorgiaFormicola.U5_W2_D3.entities.Author;
import GiorgiaFormicola.U5_W2_D3.entities.BlogPost;
import GiorgiaFormicola.U5_W2_D3.payloads.BlogPostPayload;
import GiorgiaFormicola.U5_W2_D3.repositories.BlogPostsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class BlogPostsService {
    private BlogPostsRepository blogPostsRepository;
    private AuthorsService authorsService;

    public BlogPost save(BlogPostPayload body) {
        Author authorFound = this.authorsService.findById(body.getAuthorId());
        BlogPost newBlogPost = new BlogPost(body.getCategory(), body.getTitle(), body.getContent(), body.getReadingTime(), authorFound);
        BlogPost savedBlogPost = this.blogPostsRepository.save(newBlogPost);
        log.info("Blog post with id " + savedBlogPost.getId() + " has been successfully saved!");
        return savedBlogPost;
    }

    public Page<BlogPost> findAll(int page, int size, String sortBy) {
        if (page < 0) page = 0;
        if (size < 0 || size > 100) size = 10;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.blogPostsRepository.findAll(pageable);
    }

    /*

    public BlogPost findById(long blogPostId) {
        Optional<BlogPost> found = blogPostsDB.stream().filter(blogPost -> blogPost.getId() == blogPostId).findAny();
        if (found.isEmpty()) throw new NotFoundException("blog post", blogPostId);
        else return found.get();
    }

    public BlogPost findByIdAndUpdate(long blogPostId, BlogPostPayload body) {
        BlogPost found = this.findById(blogPostId);
        found.setCategory(body.getCategory());
        found.setTitle(body.getTitle());
        found.setContent(body.getContent());
        found.setCoverURL(body.getCoverURL());
        found.setReadingTime(body.getReadingTime());
        return found;
    }

    public void findByIdAndDelete(long blogPostId) {
        BlogPost found = this.findById(blogPostId);
        this.blogPostsDB.remove(found);
    }*/


}

package hu.ulyssys.course.homework.service.impl;

import hu.ulyssys.course.homework.entities.BlogPost;
import hu.ulyssys.course.homework.entities.selectOne;
import hu.ulyssys.course.homework.service.BlogPostService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class BlogPostServiceImpl  extends AbstractServiceImpl<BlogPost> implements BlogPostService {

    public BlogPostServiceImpl() {
        for (int i = 0; i < 5; i++) {
            BlogPost blogPost = new BlogPost();
            blogPost.setId(Long.parseLong(i+""));
            blogPost.setCategory(selectOne.JAVA);
            blogPost.setTitle("Cím");
            blogPost.setContent("valami");
            blogPost.setCreatedDate(new Date());
            blogPost.setPublishedDate(new Date());
            add(blogPost);
        }

    }

    @Override
    public void update(BlogPost blog) {
        for (BlogPost blogPost:getAll()) {
            if(blogPost.getId().equals(blog.getId())) {
                blogPost.setTitle(blog.getTitle());
                blogPost.setContent(blog.getContent());
                blogPost.setCategory(blog.getCategory());
                blogPost.setPublishedDate(blog.getPublishedDate());
                blogPost.setCreatedDate(blog.getCreatedDate());
                blogPost.setLastModifiedDate(blog.getLastModifiedDate());
            }

        }
    }
}

package hu.ulyssys.course.homework.service.impl;

import hu.ulyssys.course.homework.entities.Author;
import hu.ulyssys.course.homework.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class AuthorServiceImpl extends AbstractServiceImpl<Author> implements AuthorService {

    public AuthorServiceImpl() {
        for (int i = 0; i < 5; i++) {
            Author author = new Author();
            author.setId(Long.parseLong(i+""));
            author.setCreatedDate(new Date());
            author.setUsername("almafa");
            author.setFirstName("Borza");
            author.setLastName("Márton");
            add(author);
        }
    }

    @Override
    public void update(Author blog) {
        for (Author author:getAll()) {
            if(author.getId().equals(blog.getId())) {
                author.setUsername(blog.getUsername());
                author.setFirstName(blog.getFirstName());
                author.setLastName(blog.getLastName());
                author.setCreatedDate(blog.getCreatedDate());
                author.setLastModifiedDate(blog.getLastModifiedDate());
            }

        }
    }
}













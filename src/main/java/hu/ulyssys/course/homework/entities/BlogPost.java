package hu.ulyssys.course.homework.entities;

import java.util.Date;

public class BlogPost extends AbstractType {
    private String title;
    private String content;
    private selectOne category;
    private Date publishedDate;


    public BlogPost() {
    }

    public BlogPost(Long id, Date lastModifiedDate, Date createdDate, String title, String content, selectOne category, Date publishedDate) {
        super(id, lastModifiedDate, createdDate);
        this.title = title;
        this.content = content;
        this.category = category;
        this.publishedDate = publishedDate;
    }

    public selectOne getCategory() {
        return category;
    }

    public void setCategory(selectOne category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

}

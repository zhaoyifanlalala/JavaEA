package club.banyuan.blog.bean;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private Integer id;
    @Size(min = 10,max = 20)
    private String title;
    private String content;
    private Date createdTime;
    private User author;

    public Blog() {
    }

    public Blog(Integer id, String title, String content, Date createdTime, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", author=" + author +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

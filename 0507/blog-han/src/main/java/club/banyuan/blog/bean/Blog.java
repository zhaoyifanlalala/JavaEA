package club.banyuan.blog.bean;

public class Blog {
    public Blog(Integer blogId, String title, String content) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
    }

    private Integer blogId;
    private String title;
    private String content;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
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

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

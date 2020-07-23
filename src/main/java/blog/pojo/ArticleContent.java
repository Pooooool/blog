package blog.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ArticleContent implements Serializable {
    private Long id;

    private Long article_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_by;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modify_by;

    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }
   
    public Date getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Date create_by) {
        this.create_by = create_by;
    }

    public Date getModify_by() {
        return modify_by;
    }

    public void setModify_by(Date modify_by) {
        this.modify_by = modify_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", article_id=").append(article_id);
        sb.append(", create_by=").append(create_by);
        sb.append(", modify_by=").append(modify_by);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}
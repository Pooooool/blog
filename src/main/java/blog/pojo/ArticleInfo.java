package blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class ArticleInfo implements Serializable {
    private Long id;

    private String category;

    private String title;

    private Date create_by;

    private Date modify_by;

    private String image_path;

    private Boolean is_top;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path == null ? null : image_path.trim();
    }

    public Boolean getIs_top() {
        return is_top;
    }

    public void setIs_top(Boolean is_top) {
        this.is_top = is_top;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", category=").append(category);
        sb.append(", title=").append(title);
        sb.append(", create_by=").append(create_by);
        sb.append(", modify_by=").append(modify_by);
        sb.append(", image_path=").append(image_path);
        sb.append(", is_top=").append(is_top);
        sb.append("]");
        return sb.toString();
    }
}
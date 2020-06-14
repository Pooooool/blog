package pojo;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Long id;

    private String name;

    private Long number;

    private Date create_by;

    private Date modify_by;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", create_by=").append(create_by);
        sb.append(", modify_by=").append(modify_by);
        sb.append("]");
        return sb.toString();
    }
}
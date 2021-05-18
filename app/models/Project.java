package models;


import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Project extends Model {

    @Id
    private Long id;

    private String title;
    private String content;
    private String image_project;

    @OneToMany
    private List<Comments> comments;

    public Project(Long id, String title, String content, String image_project, List<Comments> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image_project = image_project;
        this.comments = comments;
    }


    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getImage_project() {
        return image_project;
    }

    public void setImage_project(String image_project) {
        this.image_project = image_project;
    }
}

package models;


import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Project extends Model {

    @Id
    private Long id;

    private String title;
    private String content;

    @Lob
    public byte[] project_image;

    public byte[] getProject_image() {
        return project_image;
    }

    public void setProject_image(byte[] project_image) {
        this.project_image = project_image;
    }

    public Project(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Project(){

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



}

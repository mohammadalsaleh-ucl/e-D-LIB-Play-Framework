package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Id;

public class Project extends Model {

    @Id
    private Long id;
    private String title;
    private String content;


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

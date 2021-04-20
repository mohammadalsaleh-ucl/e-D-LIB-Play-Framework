package models;


import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;
import javax.persistence.*;
import java.sql.Blob;


@Entity
public class Project extends Model {

    @Id
    private Long id;

    private String title;
    private String content;

    @Lob
    public byte[] image;

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

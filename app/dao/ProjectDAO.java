package dao;

import io.ebean.DB;
import io.ebean.Finder;
import io.ebean.annotation.Transactional;
import models.Project;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

public class ProjectDAO {



    public boolean saveProject(Project project) {
        boolean projectSave = false;
        DB.save(project);
        if (project != null){
            projectSave = true;
        }
        System.out.println(projectSave);
        return projectSave;
    }


    /*public boolean add_image(Long id_project,String foto) {
        boolean projectFound = false;
        Project project = DB.find(Project.class)
                .where()
                .eq("ID", id_project)
                .findOne();

        System.out.println(foto);
        //project.setImage_project(foto);
        //updateProject(project);
        System.out.println(project.getImage_project());

        return true;
    }*/


    public static Finder<Long, Project> find = new Finder<>(Project.class);


    @Transactional
    public Long findProject(String title) {
        boolean projectFound = false;
        Project project = DB.find(Project.class)
                .where()
                .eq("TITLE", title)
                //   .and().eq("PASSWORD", password)
                .findOne();
        //System.out.println(title);
        System.out.println(project.getTitle());
        System.out.println(project.getId());
        return project.getId();
    }

    @Transactional
    public boolean updateProject(Project project,String img) {

        System.out.println("In Check update");
        boolean projectUpdate = false;
        System.out.println(project.getImage_project());
        String dml = "update project set image_project=:image_project where id = :id";

        int rows = DB.sqlUpdate(dml)
                .setParameter("image_project", img)
                .setParameter("id", project.getId())
                .execute();

        if (project != null){
            projectUpdate = true;
        }
        return projectUpdate;
    }

}

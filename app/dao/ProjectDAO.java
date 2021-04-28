package dao;

import io.ebean.DB;
import io.ebean.Finder;
import models.Project;

public class ProjectDAO {

    public boolean saveProject(Project project) {

      //  System.out.println("In Check save");
        boolean projectSave = false;
        DB.save(project);
        if (project != null){
            projectSave = true;
        }
        System.out.println(projectSave);
        return projectSave;
    }

    public static Finder<Long, Project> find = new Finder<>(Project.class);

}

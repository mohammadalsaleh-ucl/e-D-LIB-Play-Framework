package dao;

import io.ebean.DB;
import io.ebean.Finder;
import io.ebean.annotation.Transactional;
import models.Project;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Random;

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

    public static Finder<Long, Project> find = new Finder<>(Project.class);

    @Transactional
    public Long findProject(String title) {
        boolean projectFound = false;
        Project project = DB.find(Project.class)
                .where()
                .eq("TITLE", title)
                //   .and().eq("PASSWORD", password)
                .findOne();

        return project.getId();
    }

    @Transactional
    public boolean updateProject(Project project,Long id,String IMG) {

        System.out.println("In Check update");
        boolean projectUpdate = false;
        String dml = "update project set image_project=:image_project where id = :id";
        int rows = DB.sqlUpdate(dml)
                .setParameter("image_project", IMG)
                .setParameter("id",id)
                .execute();
        if (project != null){
            projectUpdate = true;
        }
        return projectUpdate;
    }


    @Transactional
    public String generateRandomString() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }


}

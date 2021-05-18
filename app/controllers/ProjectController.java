package controllers;

import com.google.inject.Inject;
import dao.ProjectDAO;
import dao.UserDAO;
import models.Project;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.admin.register;
import views.html.admin.*;
import play.libs.Files.TemporaryFile;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectController extends Controller {

    private final Form<Project> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;
    private UserDAO userDAO;
    private User user;

    @Inject
    public ProjectController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(Project.class);
        this.messagesApi = messagesApi;
        this.userDAO = userDAO;
    }

    public Result viewProject(Http.Request request) {
        return ok(project.render(form, request, messagesApi.preferred(request)));
    }


    public Result projectDetails(Long id) {
        Project p=ProjectDAO.find.ref(id);
        System.out.println(p.getTitle());
        return ok(projectdetails.render(p));
    }

    @Transactional
    public Result projectRegister(Http.Request request){
        ProjectDAO projectDAO = new ProjectDAO();
        final Form<Project> boundForm = form.bindFromRequest(request);
        Project data = boundForm.get();
        boolean isValid = projectDAO.saveProject(data);
        Long id_project=projectDAO.findProject(data.getTitle());
        System.out.println(id_project);
        upload(request,id_project);
        projectDAO.updateProject(data,id_project);
        return ok(project.render(form, request, messagesApi.preferred(request)));
    }


    public Result upload(Http.Request request,Long id_project) {
        Http.MultipartFormData<TemporaryFile> body = request.body().asMultipartFormData();
        Http.MultipartFormData.FilePart<TemporaryFile> picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            long fileSize = picture.getFileSize();
            String contentType = picture.getContentType();
            TemporaryFile file = picture.getRef();
            file.copyTo(Paths.get("C:\\Users\\melsa\\OneDrive\\Desktop\\e-d&lib\\public\\images\\uploads\\"+fileName), true);
            rename_file(fileName,id_project);
            return ok("File uploaded");
        }
            return badRequest().flashing("error", "Missing file");
    }


    public String rename_file(String file_name,Long id_project) {
        ProjectDAO projectDAO = new ProjectDAO();
        Path source = Paths.get("C:\\Users\\melsa\\OneDrive\\Desktop\\e-d&lib\\public\\images\\uploads\\"+file_name);
        try{
            Files.move(source, source.resolveSibling(id_project+"_IMG.jpg"));
            //projectDAO.add_image(id_project,foto);
            System.out.println("File name changed succesful");
        } catch (IOException e) {
            System.out.println("Rename failed");
            e.printStackTrace();
        }
        String foto=id_project+"_IMG";
        return foto;
    }


}

package controllers;

import com.google.inject.Inject;
import dao.ProjectDAO;
import dao.UserDAO;
import models.Comments;
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
    private final Form<Comments> form_comment;
    public Form<Comments> boundFormComment;

    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;
    private UserDAO userDAO;
    private User user;
    public  Project data;
    public   Project p;
    @Inject
    public ProjectController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(Project.class);
        this.form_comment = formFactory.form(Comments.class);
        this.boundFormComment = formFactory.form(Comments.class);
        this.messagesApi = messagesApi;
        this.userDAO = userDAO;
    }

    public Result viewProject(Http.Request request) {
        return ok(project.render(form, request, messagesApi.preferred(request)));
    }

    public Result add_comments(Http.Request request){
        boundFormComment= form_comment.bindFromRequest(request);
        return ok(addcomments.render(boundFormComment, request, messagesApi.preferred(request)));
    }


    public Result projectDetails(Long id) {
         p=ProjectDAO.find.ref(id);
         System.out.println(p.getTitle());
        return ok(project_details.render(p));
    }

    @Transactional
    public Result projectRegister(Http.Request request){
        ProjectDAO projectDAO = new ProjectDAO();
        final Form<Project> boundForm = form.bindFromRequest(request);
        data = boundForm.get();
        boolean isValid = projectDAO.saveProject(data);
        Long id_project=projectDAO.findProject(data.getTitle());
        System.out.println(id_project);
        upload(request,id_project);
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
            file.copyTo(Paths.get("C:\\eD&LIB\\e-D-LIB\\public\\images\\uploads\\"+fileName), true);
            rename_file(fileName,id_project);
            System.out.println(data.getTitle());
            return ok("File uploaded");
        }
            return badRequest().flashing("error", "Missing file");
    }


    public void rename_file(String file_name,Long id_project) {
        ProjectDAO projectDAO = new ProjectDAO();
        Path source = Paths.get("C:\\eD&LIB\\e-D-LIB\\public\\images\\uploads\\"+file_name);
        try{
            String foto=id_project+"_IMG"+projectDAO.generateRandomString()+".jpg";

            Files.move(source, source.resolveSibling(foto));

            projectDAO.updateProject(data,id_project,foto);
            System.out.println("File name changed succesful");
        } catch (IOException e) {
            System.out.println("Rename failed");
            e.printStackTrace();
        }
    }





}

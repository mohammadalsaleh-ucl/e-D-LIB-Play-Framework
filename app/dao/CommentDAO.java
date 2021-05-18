package dao;

import io.ebean.DB;
import io.ebean.annotation.Transactional;
import models.Comments;


public class CommentDAO {

    @Transactional
    public boolean saveComment(Comments comment) {
        boolean commentSave = false;
        DB.save(comment);
        if (comment != null){
            commentSave = true;
        }
        return commentSave;
    }

}

package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@SuppressWarnings("unchecked")
public class CommentManager extends SessionManager {

    /**
     * This method saves a comment in the database
     *
     * @param comment the comment to be saved
     */
    public void saveComment(Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }

    /**
     * This method retrieves all comments associated with an
     * image
     *
     * @param image the image whose comments we want to retrieve
     */
    public List<Comment> getCommentsByImage(Image image) {
        Session session = openSession();
        try {
            List<Comment> comments = session
                    .createCriteria(Comment.class)
                    .add(Restrictions.eq("image", image))
                    .list();
            commitSession(session);
            return comments;
        } catch(HibernateException e) {
            System.out.println("Unable to retrieve comments from database");
        }
        return null;
    }

    /**
     * This method deletes all comments associated with an
     * image
     *
     * @param image the image whose comments we want to delete
     */
    public void deleteCommentsByImage(Image image) {
        Session session = openSession();
        Query query = session.createQuery("Delete from " + Comment.class.getName() + " where image_id=:imageId");
        query.setParameter("imageId", image.getId());
        query.executeUpdate();
        commitSession(session);
    }
}

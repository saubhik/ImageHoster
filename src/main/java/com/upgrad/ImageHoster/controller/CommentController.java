package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    /**
     * This controller shows a specific image
     * @param commentBody the text of the comment we want to save
     * @param id the id of the image with which the comment is associated
     * @param session HTTP session that tells us the current user details
     *
     * @return view for the image, updated with all comments
     */
    @RequestMapping(value = "/images/{id}/comments/create", method = RequestMethod.POST)
    public String createComment(@RequestParam("comment") String commentBody,
                                @PathVariable int id,
                                HttpSession session) {

        User currUser = (User) session.getAttribute("currUser");
        Image image = imageService.getById(id);

        Comment comment = new Comment(commentBody, currUser.getUsername(), image);
        commentService.saveComment(comment);

        return "redirect:/images/" + id;
    }



}

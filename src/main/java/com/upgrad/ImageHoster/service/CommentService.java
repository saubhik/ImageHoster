package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByImage(Image image);
    void saveComment(Comment comment);
    void deleteByImage(Image image);
}

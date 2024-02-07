package com.cypsolabs.commentservice.service;

import com.cypsolabs.commentservice.enitiy.Comment;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
public interface CommentService {
    List<Comment> getAll();
    Comment saveUser(Comment comment);
    boolean deleteComment(Comment comment);
    List<Comment> findByUserid(UUID userId);
    List<Comment> findByStars(int stars);
}

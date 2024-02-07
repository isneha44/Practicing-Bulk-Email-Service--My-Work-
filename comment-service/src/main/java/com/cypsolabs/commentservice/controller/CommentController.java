package com.cypsolabs.commentservice.controller;

import com.cypsolabs.commentservice.enitiy.Comment;
import com.cypsolabs.commentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(CommentController.class);
    @Autowired
    private final CommentService service;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        loggerLog4J.info("Start getAllComments");
        try {
            loggerLog4J.info("End getAllComments");
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        loggerLog4J.info("Start saveComment");
        try {
            loggerLog4J.info("End saveComment");
            comment.setCreate(new Date());
            return ResponseEntity.ok(service.saveUser(comment));
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteComment(@RequestBody Comment comment){
        loggerLog4J.info("Start deleteComment");
        try {
            loggerLog4J.info("End deleteComment");
            service.deleteComment(comment);
            return ResponseEntity.ok("Comment Delete Success..!");
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{userId}")
    public ResponseEntity<List<Comment>> getCommentByUserId(@RequestParam UUID userId){
        loggerLog4J.info("Start getCommentByUserId");
        try {
            loggerLog4J.info("End getCommentByUserId");
            return ResponseEntity.ok(service.findByUserid(userId));
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/{stars}")
    public ResponseEntity<List<Comment>> getCommentByStars(@RequestParam int stars){
        loggerLog4J.info("Start getCommentByStars");
        try {
            loggerLog4J.info("End getCommentByStars");
            return ResponseEntity.ok(service.findByStars(stars));
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void handleException(Exception e) {
        loggerLog4J.error("Error ", e);
        e.printStackTrace();
    }
}

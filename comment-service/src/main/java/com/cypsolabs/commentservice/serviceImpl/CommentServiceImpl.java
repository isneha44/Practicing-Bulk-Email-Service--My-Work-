package com.cypsolabs.commentservice.serviceImpl;

import com.cypsolabs.commentservice.enitiy.Comment;
import com.cypsolabs.commentservice.repository.CommentRepository;
import com.cypsolabs.commentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepository repository;

    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @Override
    public Comment saveUser(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public boolean deleteComment(Comment comment) {
        repository.delete(comment);
        return true;
    }

    @Override
    public List<Comment> findByUserid(UUID userId) {
        return repository.findByUserid(userId);
    }

    @Override
    public List<Comment> findByStars(int stars) {
        return repository.findByStars(stars);
    }
}

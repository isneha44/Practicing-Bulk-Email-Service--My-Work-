package com.cypsolabs.commentservice.repository;

import com.cypsolabs.commentservice.enitiy.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByUserid(UUID userId);
    List<Comment> findByStars(int stars);
}

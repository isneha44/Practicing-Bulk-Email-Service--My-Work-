package com.dulanjanalakshan.userservice.serviceImpl;

import com.dulanjanalakshan.userservice.entity.User;
import com.dulanjanalakshan.userservice.enums.Role;
import com.dulanjanalakshan.userservice.enums.Status;
import com.dulanjanalakshan.userservice.repository.UserRepository;
import com.dulanjanalakshan.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repository;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }



    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAllByType(Role userRole) {
        return repository.findByType(userRole);
    }

    @Override
    public List<User> findAllByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findByContact(String contact) {
        return repository.findByContact(contact);
    }

    @Override
    public List<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void updateResetToken(UUID userId, int resetToken) {
        Optional<User> userOptional = repository.findById(userId);
        userOptional.ifPresent(user -> {
            user.setResetToken(resetToken);
            repository.save(user);
        });
    }

    @Override
    public Optional<User> findUserByResetToken(int resetToken) {
        return repository.findByResetToken(resetToken);
    }
}

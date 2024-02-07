package com.cypsolabs.emailmanager.service;


import com.cypsolabs.emailmanager.entity.EmailManager;
import com.cypsolabs.emailmanager.entity.Users_Email_Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface EmailManagerService {
    EmailManager SaveEmailManager (EmailManager emailManager);
    List <EmailManager> getAllEmailManager ();
    boolean EmailAllreadyExsits(String email);

    Optional<EmailManager> findByEmail(String email);



    Optional<EmailManager> findById(UUID id);

    List<EmailManager> readExcelFile(MultipartFile file) throws IOException;

    void saveAllEmailManagers(List<EmailManager> emailManagers);

    void processExcelFile(MultipartFile file);

    void processCsvFile(MultipartFile file);

    Users_Email_Id SaveEmailDetails (Users_Email_Id usersEmailId);
}

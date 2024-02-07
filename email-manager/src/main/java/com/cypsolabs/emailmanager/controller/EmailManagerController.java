package com.cypsolabs.emailmanager.controller;


import com.cypsolabs.emailmanager.entity.EmailManager;
import com.cypsolabs.emailmanager.entity.Users_Email_Id;
import com.cypsolabs.emailmanager.service.EmailManagerService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @author Imalka Gayani
 */
@RestController
@RequestMapping("/api/email-manager")
@RequiredArgsConstructor
public class EmailManagerController {
    @Autowired
    private final EmailManagerService emailManagerService;



    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <String> SaveEmailManager( @RequestBody Map<String, String> credentials){

        String[] requiredFields = {"user_id","owner_name","email"};
        validateMap(credentials,requiredFields);
        String user_id = credentials.get("user_id");
        String owner_name = credentials.get("owner_name");
        String email = credentials.get("email");

        if (emailManagerService.EmailAllreadyExsits(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email-address You Entered Already Exists");
        }

        EmailManager emailmanager = new EmailManager();
        emailmanager.setCreateDate(new Date());
        emailmanager.setUpdateDate(new Date());
        emailmanager.setUser_id(UUID.fromString(user_id));
        emailmanager.setOwner_name(owner_name);
        emailmanager.setEmail(email);

        emailManagerService.SaveEmailManager(emailmanager);
        return ResponseEntity.status(HttpStatus.CREATED).body("Email-address has been Saved Successfully");
    }
    @GetMapping("/getAllEmail")
    @ResponseStatus(HttpStatus.OK)
    public List<EmailManager> getAllEmailManager() {
        return emailManagerService.getAllEmailManager();
    }
    @PostMapping("/{findByEmail}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Optional<EmailManager>> findByEmail(@PathVariable String email) {
        Optional<EmailManager> emailManager = emailManagerService.findByEmail(email);
        if (emailManager.isPresent()) {
            return ResponseEntity.ok(emailManager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmailManager> findById(@PathVariable UUID id) {
        Optional<EmailManager> emailManager = emailManagerService.findById(id);

        if (emailManager.isPresent()) {
            return ResponseEntity.ok(emailManager.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmail( @RequestBody Map<String, String> credentials) {
        String[] requiredFields = {"id","user_id","email","owner_name"};
        validateMap(credentials,requiredFields);
        UUID id = UUID.fromString(credentials.get("id"));
        UUID user_id = UUID.fromString(credentials.get("user_id"));
        String email = credentials.get("email");
        String owner_name = credentials.get("owner_name");

        Optional<EmailManager> existingEmail = emailManagerService.findById(id);

        if (existingEmail.isPresent()) {
            EmailManager emailToUpdate = existingEmail.get();

            emailToUpdate.setUser_id(user_id);
            emailToUpdate.setEmail(email);
            emailToUpdate.setOwner_name(owner_name);
            emailToUpdate.setUpdateDate(new Date());


            emailManagerService.SaveEmailManager(emailToUpdate);
            return ResponseEntity.ok("Email-address Updated Successfully");

        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please provide a file to upload.");
        }

        String contentType = file.getContentType();

        if (contentType != null && contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            // Handle Excel file
            try {
                return uploadExcelFile(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (contentType != null && contentType.equals("text/csv")) {
            // Handle CSV file
            try {
                return uploadCsvFile(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return ResponseEntity.badRequest().body("Unsupported file type: " + contentType);
        }
    }

    private ResponseEntity<String> uploadExcelFile(MultipartFile file) throws IOException {
        // Process Excel file using existing logic
        emailManagerService.processExcelFile(file);
        return ResponseEntity.ok("Excel file uploaded successfully.");
    }

    private ResponseEntity<String> uploadCsvFile(MultipartFile file) throws IOException {
        // Process CSV file using specific logic
        emailManagerService.processCsvFile(file);
        return ResponseEntity.ok("CSV file uploaded successfully.");
    }


    @PostMapping("/saveEmailId")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <String> SaveEmailDetails(@RequestBody Map<String, String> credentials, Users_Email_Id usersEmailId){

        String[] requiredFields = {"id","user_id"};
        validateMap(credentials,requiredFields);

        String id = credentials.get("id");
        String userId = credentials.get("userId");

        if (emailManagerService.EmailAllreadyExsits(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email-Id You Entered Already Exists");
        }

        EmailManager emailDetailManager = new EmailManager();

        emailDetailManager.setCreateDate(new Date());
        emailDetailManager.setId(UUID.fromString(id));
        emailDetailManager.setUser_id(UUID.fromString(userId));

        emailManagerService.SaveEmailDetails(usersEmailId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Email-Id has been Saved Successfully");


    }








    private void validateMap(Map<String, String> assetCategoryMap, String[] requiredFields) {
        for (String field : requiredFields) {
            if (assetCategoryMap.get(field) == null || assetCategoryMap.get(field).isEmpty()) {
                throw new IllegalArgumentException("Not found " + field);
            }
        }
    }

}

package com.dulanjanalakshan.whatsappmanager.controller;

import com.dulanjanalakshan.whatsappmanager.entity.WhatsappManager;
import com.dulanjanalakshan.whatsappmanager.service.WhatsappManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Imalka Gayani
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/whatsapp")
public class WhatsappManagerController {
    @Autowired
    private final WhatsappManagerService whatsappManagerService;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveWhatsapp(@RequestBody  Map<String, String> credentials) {

        String[] requiredFields = {"user_id","country_code","mobile","owner_name"};
        validateMap(credentials,requiredFields);
        UUID user_id = UUID.fromString(credentials.get("user_id"));
        String country_code = credentials.get("country_code");
        String mobile = credentials.get("mobile");
        String owner_name = credentials.get("owner_name");


        if (whatsappManagerService.MobileExistsAllReady(mobile)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Whatsapp Number You Entered Already Exists");
        }
        WhatsappManager whatsappManager = new WhatsappManager();
        whatsappManager.setCreateDate(new Date());
        whatsappManager.setUpdateDate(new Date());
        whatsappManager.setUser_id(user_id);
        whatsappManager.setCountry_code(country_code);
        whatsappManager.setMobile(mobile);
        whatsappManager.setOwner_name(owner_name);

        whatsappManagerService.saveWhatsapp(whatsappManager);
        return ResponseEntity.status(HttpStatus.CREATED).body("Whatsapp Number Saved Successfully");
    }

    @GetMapping ("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<WhatsappManager> getAllWhatsappManager() {
        return whatsappManagerService.getAllWhatsappManager();
    }

    @PostMapping("/{mobile}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Optional<WhatsappManager>> findByMobile(@PathVariable String mobile) {
        Optional<WhatsappManager> whatsappManager = whatsappManagerService.findByMobile(mobile);
        if (whatsappManager.isPresent()) {
            return ResponseEntity.ok(whatsappManager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWhatsapp( @RequestBody Map<String, String> credentials) {
        String[] requiredFields = {"id","user_id","country_code","mobile","owner_name"};
        validateMap(credentials,requiredFields);
        UUID id = UUID.fromString(credentials.get("id"));
        UUID user_id = UUID.fromString(credentials.get("user_id"));
        String country_code = credentials.get("country_code");
        String mobile = credentials.get("mobile");
        String owner_name = credentials.get("owner_name");

        Optional<WhatsappManager> existingWhatsapp = whatsappManagerService.findById(id);

        if (existingWhatsapp.isPresent()) {
            WhatsappManager whatsappToUpdate = existingWhatsapp.get();

            whatsappToUpdate.setUser_id(user_id);
            whatsappToUpdate.setCountry_code(country_code);
            whatsappToUpdate.setMobile(mobile);
            whatsappToUpdate.setOwner_name(owner_name);
            whatsappToUpdate.setUpdateDate(new Date());


            whatsappManagerService.saveWhatsapp(whatsappToUpdate);
            return ResponseEntity.ok("WhatsApp Number Updated Successfully");

        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<WhatsappManager> findById(@PathVariable UUID id) {
        Optional<WhatsappManager> whatsappManager = whatsappManagerService.findById(id);

        if (whatsappManager.isPresent()) {
            return ResponseEntity.ok(whatsappManager.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void validateMap(Map<String, String> assetCategoryMap, String[] requiredFields) {
        for (String field : requiredFields) {
            if (assetCategoryMap.get(field) == null || assetCategoryMap.get(field).isEmpty()) {
                throw new IllegalArgumentException("Not found " + field);
            }
        }
    }

}








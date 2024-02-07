package com.dulanjanalakshan.systemlog.controller;

import com.dulanjanalakshan.systemlog.entity.Systemlog;
import com.dulanjanalakshan.systemlog.service.SystemlogService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */

@RestController
@RequestMapping("api/system-log")
@RequiredArgsConstructor
public class SystemlogController {
    @Autowired
    private final SystemlogService systemlogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Systemlog saveSystemlog(@RequestBody Systemlog systemlog) {
     systemlog.setCreateDate(new Date());
        return systemlogService.saveSystemlog(systemlog);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Systemlog> getAllSystemlog() {
        return systemlogService.getAllSystemlog();
    }

    @PostMapping("/{userid}")
    public ResponseEntity<Optional<Systemlog>> findbyUserId(@PathVariable String userid) {
        UUID id = UUID.fromString(userid);
        Optional<Systemlog> systemlog = systemlogService.findByUserid(id);
        if (systemlog.isPresent()) {
            return ResponseEntity.ok(systemlog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @PostMapping("/{byLocation}")
     public ResponseEntity <Optional<Systemlog>> findByLocation(@RequestParam String location) {
         Optional<Systemlog> systemlog = systemlogService.findByLocation(location);
         if (systemlog.isPresent()) {
             return ResponseEntity.ok(systemlog);
         } else {
             return ResponseEntity.notFound().build();
         }
     }


}








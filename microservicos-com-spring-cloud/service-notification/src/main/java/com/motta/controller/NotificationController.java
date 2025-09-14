package com.motta.controller;

import com.motta.dto.NotificationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping
    public ResponseEntity<Void> sendNotifications(@RequestBody NotificationRequest request){
        System.out.println(request.message());
        return ResponseEntity.ok().build();
    }

}

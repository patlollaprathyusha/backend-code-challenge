package com.midwesttape.project.challengeapplication.rest;

import com.midwesttape.project.challengeapplication.model.Address;
import com.midwesttape.project.challengeapplication.model.User;
import com.midwesttape.project.challengeapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/users/{userId}")
    public ResponseEntity<?> user(@PathVariable final Long userId) {
        Address addressResponse= userService.getAddressByUserId(userId);
        return new ResponseEntity<>(addressResponse,HttpStatus.OK);
    }
    @PutMapping ("/v1/users")
    public ResponseEntity<?> updateUser( @RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}

package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.User;
import com.sulistyan.mutabaahku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody User userParam) {

        User user = userRepository.findUserByUsernamePassword(userParam.getUsername(), userParam.getPassword());

        if(user == null){
            throw new ResourceNotFoundException("Gagal Login :: " + userParam.getUsername());
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", user);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
}

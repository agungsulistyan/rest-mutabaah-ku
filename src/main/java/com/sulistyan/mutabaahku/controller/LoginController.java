package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.User;
import com.sulistyan.mutabaahku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> login(@RequestParam Map<String, String> body) {

        User user = userRepository.findUserByUsernamePassword(body.get("username"), body.get("password"));

        if(user == null){
            throw new ResourceNotFoundException("Gagal Login :: " + body.get("username"));
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", user);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    /*
    @PostMapping(value = "/login")
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
    * */
}

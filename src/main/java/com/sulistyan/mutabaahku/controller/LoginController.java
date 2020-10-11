package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.User;
import com.sulistyan.mutabaahku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        HashMap<String, Object> hmap = new HashMap<String, Object>();

        if(user == null){
            hmap.put("status", HttpStatus.NOT_FOUND.value());
            hmap.put("message", "Gagal Login.");
            return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.NOT_FOUND);
        }

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
    S*/
}

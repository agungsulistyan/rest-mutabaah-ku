package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.User;
import com.sulistyan.mutabaahku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<?> getUser(){
        List<User> users = new ArrayList<>();

        users = userRepository.findAll();

        if(users == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", users);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", user);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {

        final User saveUser = userRepository.save(user);

        if(saveUser == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", saveUser);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @PostMapping(value = "/registerUser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> registerUser(@RequestParam Map<String, String> body) {

        User user = new User();
        user.setNama(body.get("nama"));
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));

        final User saveUser = userRepository.save(user);

        if(saveUser == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", saveUser);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable(value = "id") Integer userId,
            @Valid @RequestBody User userParam) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        user.setNama(userParam.getNama());
        final User updatedUser = userRepository.save(user);

        if(updatedUser == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("user", updatedUser);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        userRepository.delete(user);

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("deleted", Boolean.TRUE);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }


}

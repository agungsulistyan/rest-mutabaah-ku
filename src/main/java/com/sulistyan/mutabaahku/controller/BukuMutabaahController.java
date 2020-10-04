package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.BukuMutabaah;
import com.sulistyan.mutabaahku.repository.BukuMutabaahRepository;
import com.sulistyan.mutabaahku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/")
public class BukuMutabaahController {

    @Autowired
    private BukuMutabaahRepository bkmtRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/bkmt")
    public ResponseEntity<?> getBkmt(){
        List<BukuMutabaah> bkmt = new ArrayList<>();

        bkmt = bkmtRepository.findAll();

        if(bkmt == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bkmt", bkmt);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @GetMapping("/bkmt/{id}")
    public ResponseEntity<?> getBkmtById(
            @PathVariable(value = "id") Integer bkmtId) throws ResourceNotFoundException {
        BukuMutabaah bkmt = bkmtRepository.findById(bkmtId)
                .orElseThrow(() -> new ResourceNotFoundException("BukuMutabaah not found :: " + bkmtId));

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bkmt", bkmt);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @GetMapping("/bkmt/user/{user_id}")
    public ResponseEntity<?> getBkmtByUserId(
            @PathVariable(value = "user_id") Integer userId) throws ResourceNotFoundException {

        BukuMutabaah bkmt = bkmtRepository.findBkmtByUserId(userId);

        if(bkmt == null){
            throw new ResourceNotFoundException("User not found :: " + userId);
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bkmt", bkmt);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

}

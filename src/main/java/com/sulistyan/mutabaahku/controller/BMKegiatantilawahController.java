package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.BMKegiatanTilawah;
import com.sulistyan.mutabaahku.entity.User;
import com.sulistyan.mutabaahku.repository.BMKegiatanTilawahRepository;
import com.sulistyan.mutabaahku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/")
public class BMKegiatantilawahController {

    @Autowired
    private BMKegiatanTilawahRepository bmKegiatanTilawahRepository;

    @Autowired
    private UserRepository userRepository;

    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");

    @PostMapping("/bmkt/bkmt/{user_id}")
    public ResponseEntity<?> createBmkt(@PathVariable(value = "user_id") Integer user_id, @Valid @RequestBody BMKegiatanTilawah bmKegiatanTilawah) {

        bmKegiatanTilawah.setIdUser(user_id);

        final BMKegiatanTilawah bmKegiatanTilawahSave = bmKegiatanTilawahRepository.save(bmKegiatanTilawah);

        if(bmKegiatanTilawahSave == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bmkegiatan_tilawah", bmKegiatanTilawahSave);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @PutMapping("/bmkt/{bmkt_id}")
    public ResponseEntity<?> updateBmkt(
            @PathVariable(value = "bmkt_id") Integer bmktId,
            @Valid @RequestBody BMKegiatanTilawah bmKegiatanTilawahParam) throws ResourceNotFoundException {
        BMKegiatanTilawah bmKegiatanTilawah = bmKegiatanTilawahRepository.findById(bmktId)
                .orElseThrow(() -> new ResourceNotFoundException("Bmkt not found :: " + bmktId));

        bmKegiatanTilawah.setAyat(bmKegiatanTilawahParam.getAyat());
        bmKegiatanTilawah.setSurat(bmKegiatanTilawahParam.getSurat());
        bmKegiatanTilawah.setTanggal(bmKegiatanTilawahParam.getTanggal());

        final BMKegiatanTilawah updateBmKegiatanTilawah = bmKegiatanTilawahRepository.save(bmKegiatanTilawah);

        if(updateBmKegiatanTilawah == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bmkegiatan_tilawah", updateBmKegiatanTilawah);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @GetMapping("/bmkt")
    public ResponseEntity<?> getBmkt(){
        List<BMKegiatanTilawah> bmkts = new ArrayList<>();

        bmkts = bmKegiatanTilawahRepository.findAll();

        if(bmkts == null){
            throw new ResourceNotFoundException("Gagal Sistem");
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bmkegiatan_tilawah", bmkts);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @GetMapping("/bmkt/bkmt/{user_id}")
    public ResponseEntity<?> getBmktByBkmtId(
            @PathVariable(value = "user_id") Integer user_id) throws ResourceNotFoundException {

        List<BMKegiatanTilawah> bmKegiatanTilawahs = bmKegiatanTilawahRepository.findBmktByUserId(user_id);

        if(bmKegiatanTilawahs == null){
            throw new ResourceNotFoundException("BukuMutabaah not found :: " + user_id);
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bmkegiatan_tilawah", bmKegiatanTilawahs);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @PostMapping(value = "/addDataTilawah", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> addDataTilawah(@RequestParam Map<String, String> body) {

        User user = userRepository.findById(Integer.parseInt(body.get("user_id")))
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " ));

        BMKegiatanTilawah bmKegiatanTilawah = new BMKegiatanTilawah();

        try {

            bmKegiatanTilawah.setIdUser(user.getId());
            bmKegiatanTilawah.setTanggal(dateFormat1.parse(body.get("tanggal").toString()));
            bmKegiatanTilawah.setSurat(Integer.parseInt(body.get("surat").toString()));
            bmKegiatanTilawah.setAyat(Integer.parseInt(body.get("ayat").toString()));

        }catch(Exception e){

        }

        bmKegiatanTilawah = bmKegiatanTilawahRepository.save(bmKegiatanTilawah);

        HashMap<String, Object> hmap = new HashMap<String, Object>();

        if(bmKegiatanTilawah != null){
            hmap.put("status", HttpStatus.OK.value());
            hmap.put("message", "success");
        }

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }

    @PostMapping(value = "/getDataTilawah", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> getDataTilawah(@RequestParam Map<String, String> body) {

        User user = userRepository.findById(Integer.parseInt(body.get("user_id")))
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " ));

        List<BMKegiatanTilawah> bmKegiatanTilawahs = bmKegiatanTilawahRepository.findBmktByUserId(user.getId());

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bmKegiatanTilawah", bmKegiatanTilawahs);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }



}

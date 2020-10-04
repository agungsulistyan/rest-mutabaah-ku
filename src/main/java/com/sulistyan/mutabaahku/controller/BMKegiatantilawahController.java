package com.sulistyan.mutabaahku.controller;

import com.sulistyan.mutabaahku.entity.BMKegiatanTilawah;
import com.sulistyan.mutabaahku.repository.BMKegiatanTilawahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/")
public class BMKegiatantilawahController {

    @Autowired
    private BMKegiatanTilawahRepository bmKegiatanTilawahRepository;

    @PostMapping("/bmkt/bkmt/{bkmt_id}")
    public ResponseEntity<?> createBmkt(@PathVariable(value = "bkmt_id") Integer bkmtId, @Valid @RequestBody BMKegiatanTilawah bmKegiatanTilawah) {

        bmKegiatanTilawah.setIdBukuMutabaah(bkmtId);

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

    @GetMapping("/bmkt/bkmt/{bkmt_id}")
    public ResponseEntity<?> getBmktByBkmtId(
            @PathVariable(value = "bkmt_id") Integer bkmtId) throws ResourceNotFoundException {

        List<BMKegiatanTilawah> bmKegiatanTilawahs = bmKegiatanTilawahRepository.findBmktByBkmtId(bkmtId);

        if(bmKegiatanTilawahs == null){
            throw new ResourceNotFoundException("BukuMutabaah not found :: " + bkmtId);
        }

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("status", HttpStatus.OK.value());
        hmap.put("message", "success");
        hmap.put("bmkegiatan_tilawah", bmKegiatanTilawahs);

        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }



}

package com.sulistyan.mutabaahku.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bm_kegiatantilawah")
@EntityListeners(AuditingEntityListener.class)
public class BMKegiatanTilawah {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_bmkt")
    private int idBmKegiatanTilawah;

    @Column(name="id_bukumutabaah")
    private int idBukuMutabaah;

    @Column(name="tanggal")
    private Date tanggal;

    @Column(name="surat")
    private int surat;

    @Column(name="ayat")
    private int ayat;

    public int getIdBmKegiatanTilawah() {
        return idBmKegiatanTilawah;
    }

    public void setIdBmKegiatanTilawah(int idBmKegiatanTilawah) {
        this.idBmKegiatanTilawah = idBmKegiatanTilawah;
    }

    public int getIdBukuMutabaah() {
        return idBukuMutabaah;
    }

    public void setIdBukuMutabaah(int idBukuMutabaah) {
        this.idBukuMutabaah = idBukuMutabaah;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getSurat() {
        return surat;
    }

    public void setSurat(int surat) {
        this.surat = surat;
    }

    public int getAyat() {
        return ayat;
    }

    public void setAyat(int ayat) {
        this.ayat = ayat;
    }

    public BMKegiatanTilawah(int idBukuMutabaah, Date tanggal, int surat, int ayat) {
        this.idBukuMutabaah = idBukuMutabaah;
        this.tanggal = tanggal;
        this.surat = surat;
        this.ayat = ayat;
    }

    public BMKegiatanTilawah(){

    }

    @Override
    public String toString() {
        return "BMKegiatanTilawah{" +
                "idBmKegiatanTilawah=" + idBmKegiatanTilawah +
                ", idBukuMutabaah=" + idBukuMutabaah +
                ", tanggal=" + tanggal +
                ", surat=" + surat +
                ", ayat=" + ayat +
                '}';
    }
}

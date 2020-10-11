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

    @Column(name="id_user")
    private int idUser;

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public BMKegiatanTilawah(int idUser, Date tanggal, int surat, int ayat) {
        this.idUser = idUser;
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
                ", idUser=" + idUser +
                ", tanggal=" + tanggal +
                ", surat=" + surat +
                ", ayat=" + ayat +
                '}';
    }
}

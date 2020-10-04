package com.sulistyan.mutabaahku.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bukumutabaah")
@EntityListeners(AuditingEntityListener.class)
public class BukuMutabaah {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_bukumutabaah")
    private int idBkmt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bukumutabaah", referencedColumnName = "id_bukumutabaah")
    private List<BMKegiatanTilawah> bmKegiatanTilawah;

    public List<BMKegiatanTilawah> getBmKegiatanTilawah() {
        return bmKegiatanTilawah;
    }

    public void setBmKegiatanTilawah(List<BMKegiatanTilawah> bmKegiatanTilawah) {
        this.bmKegiatanTilawah = bmKegiatanTilawah;
    }

    public int getIdBkmt() {
        return idBkmt;
    }

    public void setIdBkmt(int idBkmt) {
        this.idBkmt = idBkmt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BukuMutabaah(){

    }

    public BukuMutabaah(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BukuMutabaah{" +
                "idBkmt=" + idBkmt +
                ", user=" + user +
                ", bmKegiatanTilawah=" + bmKegiatanTilawah +
                '}';
    }
}

package com.sulistyan.mutabaahku.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_user")
    private int id;
    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private List<BMKegiatanTilawah> bmKegiatanTilawah;

    public List<BMKegiatanTilawah> getBmKegiatanTilawah() {
        return bmKegiatanTilawah;
    }

    public void setBmKegiatanTilawah(List<BMKegiatanTilawah> bmKegiatanTilawah) {
        this.bmKegiatanTilawah = bmKegiatanTilawah;
    }
    */
    @Column(name="nama_user")
    private String nama;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User(){

    }

    public User(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                /*", bmKegiatanTilawah=" + bmKegiatanTilawah +*/
                ", nama='" + nama + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

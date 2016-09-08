package com.chyld.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "positions")
@Data
public class Position {
    private int id;
    private Run run;
    private float latitude;
    private float longitude;
    private float altitude;
    private Date currentTime;

    public Position() {
    }

    public Position(Run run) {
        this.run = run;
    }

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="run_id")
    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    @Column(name = "latitude")
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude")
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Column(name = "altitude")
    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    @Column(name = "cur_time")
    public Date getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

}

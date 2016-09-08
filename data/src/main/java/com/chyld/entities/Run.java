package com.chyld.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "runs")
@Data
public class Run {
    private int id;
    private Device device;
    private Date startTime;
    private Date endTime;
    private boolean active;

    public Run() {
    }

    public Run(Device device) {
        this.device = device;
    }

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="device_id")
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Column(nullable = false, name = "start_time")
    @CreationTimestamp
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Column(columnDefinition="bit(1) default '1'")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

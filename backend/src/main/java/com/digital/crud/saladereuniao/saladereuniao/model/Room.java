package com.digital.crud.saladereuniao.saladereuniao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meetingroom")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "startHour", nullable = false)
    private String startHour;

    @Column(name = "endHour", nullable = false)
    private String endHour;

    public Room () {}

    public Room (Long id, String name, String date, String startHour, String endHour ){
        this.id = id;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour =endHour;
    }

    @Override
    public String toString(){
        return "Room [id=" + id + ", name=" + name + ", date=" + date + " , startHour=" + startHour + ", endHour=" + endHour + "]";
    }
}

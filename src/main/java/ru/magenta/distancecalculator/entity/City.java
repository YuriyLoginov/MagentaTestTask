package ru.magenta.distancecalculator.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude")
    private Integer latitude;
    @Column(name = "longitude")
    private Integer longitude;

    @OneToMany(mappedBy = "toCity")
    private List<Distance> toDistance;

    @OneToMany(mappedBy = "fromCity")
    private List<Distance> fromDistance;
}
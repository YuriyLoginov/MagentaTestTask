package ru.magenta.distancecalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "distance")
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fromCity")
    private City fromCity;

    @ManyToOne
    @JoinColumn(name = "toCity")
    private City toCity;

    @Column(name = "distance")
    private Long distance;

}

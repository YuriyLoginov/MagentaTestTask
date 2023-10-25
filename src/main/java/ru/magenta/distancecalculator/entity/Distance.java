package ru.magenta.distancecalculator.entity;

import lombok.*;

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
    private Double distance;

    public Distance(City fromCity, City toCity, Double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }
}

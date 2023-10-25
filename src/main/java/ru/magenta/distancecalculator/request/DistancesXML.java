package ru.magenta.distancecalculator.request;

import lombok.Getter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Distance")
@Getter
public class DistancesXML {
    Double distance;
    Long toCity;
    Long fromCity;

    @XmlElement(name = "distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @XmlElement(name = "to_city")
    public void setToCity(Long toCity) {
        this.toCity = toCity;
    }
    @XmlElement(name = "from_city")
    public void setFromCity(Long fromCity) {
        this.fromCity = fromCity;
    }
}

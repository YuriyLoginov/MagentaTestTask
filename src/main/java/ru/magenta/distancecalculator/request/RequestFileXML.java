package ru.magenta.distancecalculator.request;

import lombok.*;
import ru.magenta.distancecalculator.entity.City;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Data")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class RequestFileXML {
    @XmlElementWrapper(name = "Cities")
    @XmlElement(name = "City", type = City.class)
    List<City> cities;

    @XmlElementWrapper(name = "Distances")
    @XmlElement(name = "Distance", type = DistancesXML.class)
    List<DistancesXML> distances;
}

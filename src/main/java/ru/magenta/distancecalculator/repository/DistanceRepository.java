package ru.magenta.distancecalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.entity.Distance;

import java.util.Optional;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {

    @Query(value = "select * from distance d where d.from_city = :fromCity and d.to_city = :toCity", nativeQuery = true)
    Optional<Distance> findDistanceByFromCityAndToCity(City fromCity, City toCity);
}

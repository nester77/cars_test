package IG.test.repository;

import IG.test.entity.Car;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.id = :id")
    Car getById(Long id);

    @Query("UPDATE Car SET deletedCar=true WHERE id=:id")
    @Modifying
    void deleteCarById(Long id);

}

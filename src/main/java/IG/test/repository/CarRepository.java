package IG.test.repository;

import IG.test.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c")
    public List<Car> getAllCar();

    @Query("SELECT c FROM Car c WHERE c.id = :id")
    public Car getCarById(Long id);
//
//    @Query("SELECT c FROM Car c WHERE c.brand = :brand")
//    public List<Car> getCarByBrand(String brand);
//
//    @Query("SELECT c FROM Car c WHERE c.model = :model")
//    public List<Car> getCarByModel(String model);
//
//    @Query("SELECT c FROM Car c WHERE c.year_of_issue BETWEEN minYear AND maxYear")
//    public List<Car> getCarByYear(Integer minYear, Integer maxYear );
//
//    @Query("SELECT c FROM Car c WHERE c.engine_capacity BETWEEN minCapacity AND maxCapacity")
//    public List<Car> getCarByEngine(Double minCapacity, Double maxCapacity );
//
//    @Query("SELECT c FROM Car c WHERE c.mileage BETWEEN minMileage AND maxMileage")
//    public List<Car> getCarByMileage(Integer minMileage, Integer maxMileage );
//
//    @Query("SELECT c FROM Car c WHERE c.price BETWEEN minPrice AND maxPrice")
//    public List<Car> getCarByPrice(Integer minPrice, Integer maxPrice );



}

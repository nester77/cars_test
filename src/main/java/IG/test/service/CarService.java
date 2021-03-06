package IG.test.service;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import org.springframework.data.domain.Page;

public interface CarService {

    Page<Car> getAllCarsForUser(CarPage carPage, CarSearchCriteria carSearchCriteria);

    Car getCarByIdForUser(Long id);

    Car getCarByIdForAdmin(Long id);

    void deleteCarById(long id);

    void saveCar(Car car);

    Page<Car> getAllCarsForAdmin(CarPage carPage, CarSearchCriteria carSearchCriteria);
}



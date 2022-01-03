package IG.test.service;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface CarService {


    List<Car> getAllCarsForUser(int pageNo, int pageSize);

    Car getCarByIdForUser(Long id);

    Car getCarByIdForAdmin(Long id);

    void deleteCarById(long id);

    void saveEntity(Car car);

    Page<Car> getAllCarsForAdmin(CarPage carPage, CarSearchCriteria carSearchCriteria);
}



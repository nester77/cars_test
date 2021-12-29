package IG.test.service;

import IG.test.entity.Car;

import java.util.List;


public interface CarService {

    List<Car> getAllCarsForUser();

    Car getCarByIdForUser(Long id);

    List<Car> getAllCarsForAdmin();

    Car getCarByIdForAdmin(Long id);

    void deleteCarById(long id);

}


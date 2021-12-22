package IG.test.service;

import IG.test.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {

    public List<Car> getAllCar ();

    public Car getCarById(Long id);
}

package IG.test.service;

import IG.test.entity.Car;
import IG.test.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCar() {

        return carRepository.getAllCar();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.getCarById(id);
    }
}

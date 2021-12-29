package IG.test.service;

import IG.test.entity.Car;
import IG.test.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {


    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCarsForUser() {

        return carRepository.getAllCarForUser();
    }

    @Override
    public Car getCarByIdForUser(Long id) {
        Car car = carRepository.getById(id);

        return car;
    }

    @Override
    public List<Car> getAllCarsForAdmin() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarByIdForAdmin(Long id) {
        return carRepository.getById(id);
    }

    @Override
    @Transactional
    public void deleteCarById(long id) {
        carRepository.deleteCarById(id);

    }

//    @Override
//    public int releaseYear(Long id) {
//        return carRepository.releaseYear(id);
//    }
}

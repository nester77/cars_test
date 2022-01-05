package IG.test.service;

import IG.test.entity.Car;
import IG.test.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Test
    void saveCar() {
        Car car = new Car();
        carService.saveCar(car);
        Mockito.verify(carRepository, Mockito.times(1)).save(car);

    }
}
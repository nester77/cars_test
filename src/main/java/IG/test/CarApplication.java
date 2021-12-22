package IG.test;

import IG.test.entity.Car;
import IG.test.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {

    @Autowired
    private CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        List<Car> carList = carService.getAllCar();
//        for (Car car : carList) {
//            System.out.println(car);
//        }
//
//        Car car = carService.getCarById(new Long(3));
//        System.out.println(car);
    }
}
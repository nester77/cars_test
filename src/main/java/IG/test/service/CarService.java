package IG.test.service;

import IG.test.entity.Car;

import javax.transaction.Transactional;
import java.util.List;


public interface CarService {

    List<Car> getAllCarsForUser();

    Car getCarByIdForUser(Long id);

    List<Car> getAllCarsForAdmin(int pageNo, int pageSize);

    Car getCarByIdForAdmin(Long id);

    void deleteCarById(long id);

    void saveEntity(Car car);
}

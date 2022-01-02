package IG.test.service;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface CarService {

    Page<Car> getAllCarsForAdmin3(CarPage employeePage, CarSearchCriteria employeeSearchCriteria);


    List<Car> getAllCarsForUser(int pageNo, int pageSize);

    Car getCarByIdForUser(Long id);

    List<Car> getAllCarsForAdmin(int pageNo, int pageSize);

    Car getCarByIdForAdmin(Long id);

    void deleteCarById(long id);

    void saveEntity(Car car);

    Page<Car> getAllCarsForAdmin2(PageRequest pageRequest);
}


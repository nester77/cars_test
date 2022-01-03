package IG.test.service;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import IG.test.repository.CarCriteriaRepository;
import IG.test.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private CarRepository carRepository;
    private final CarCriteriaRepository carCriteriaRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarCriteriaRepository carCriteriaRepository) {
        this.carRepository = carRepository;
        this.carCriteriaRepository = carCriteriaRepository;
    }


    @Override
    public List<Car> getAllCarsForUser(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Car> pagedResult = carRepository.getAllCarForUser(paging);
        return pagedResult.toList();

    }

    @Override
    public Car getCarByIdForUser(Long id) {
        Car car = carRepository.getById(id);

        return car;
    }


    @Override
    public Page<Car> getAllCarsForAdmin(CarPage carPage,
                                        CarSearchCriteria carSearchCriteria) {
        return carCriteriaRepository.findAllWithFilters(carPage, carSearchCriteria);
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

    @Override
    public void saveEntity(Car car) {
        carRepository.save(car);
    }

}

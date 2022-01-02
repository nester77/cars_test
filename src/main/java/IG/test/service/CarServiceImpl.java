package IG.test.service;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import IG.test.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private CarRepository carRepository;


    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
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
    public List<Car> getAllCarsForAdmin(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Car> pagedResult = carRepository.findAll(paging);
        return pagedResult.toList();
    }

    @Override
    public Page<Car> getAllCarsForAdmin2(PageRequest pageRequest) {
        return carRepository.findAll(pageRequest);
    }

    @Override
    public Page<Car> getAllCarsForAdmin3(CarPage carPage, CarSearchCriteria carSearchCriteria) {
        String filter = "X5";
        PageRequest pageRequest = PageRequest.of(
                carPage.getPageNumber(),
                carPage.getPageSize(),
                carPage.getSortDirection(),
                carPage.getSortBy()

        );

System.out.println(pageRequest);
        System.out.println(pageRequest.getSort());
        return carRepository.getAllCarForAdmin(pageRequest, filter);
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


//    @Override
//    public int releaseYear(Long id) {
//        return carRepository.releaseYear(id);
//    }
}

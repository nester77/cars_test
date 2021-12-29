package IG.test;

import IG.test.entity.Car;
import IG.test.repository.CarRepository;
import IG.test.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class CarApplication implements CommandLineRunner {

    @Autowired
    private CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Override
    public void run(String... args) throws Exception {


//        List<Car> carList = carService.getAllCarsForUser();
//        for (Car car : carList) {
//            System.out.println(car);
//        }

//        Car car1;
//        System.out.println(car1 = carService.getCarsByIdForAdmin((long) 2));

        Car car;
        System.out.println(car= carService.getCarByIdForUser((long) 2));


////        System.out.println(carService.releaseYear((long) 2));
//
//        Car car = carService.getCarById(new Long(3));
//        System.out.println(car);
    }
}
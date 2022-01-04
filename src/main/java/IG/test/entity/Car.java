package IG.test.entity;

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "car")
@ApiModel(value = "class car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message= "Brand should not be empty")
    @Size(min=2, max=30, message= "Brand should be between 2 and 30 characters")
    private String brand;

    @NotBlank(message= "Model should not be empty" )
    @Size(min=2, max=30, message= "Model should be between 2 and 30 characters")
    private String model;

    @Column(name = "year_of_issue")
    @Min(value=1900, message= "Year of issue should be between 1900 and 2022")
    @Max(value=2022, message= "Year of issue should be between 1900 and 2022")
    private int yearOfIssue;

    @Column(name = "engine_capacity")
    @Min(value=1, message= "Engine capacity should be between 1 and 10 L")
    @Max(value=10, message= "Engine capacity should be between 1 and 10 L")
    private double engineCapacity;

    @Min(value=1, message= "Mileage should be between 1 and 10.000.000 km")
    @Max(value=10000000, message= "Mileage should be between 1 and 10.000.000 km")
    private int mileage;

    @Min(value=1, message= "Price should be between 1 and 100.000 $")
    @Max(value=100000, message= "Price should be between 1 and 100.000 $")
    private int price;

    @Column(name = "deleted_car")
    @NotNull(message= "DeletedCar should be true or false")
    private boolean deletedCar;




    public Car(long id, String brand, String model, int yearOfIssue, double engineCapacity, int mileage, int price, boolean deletedCar) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.engineCapacity = engineCapacity;
        this.mileage = mileage;
        this.price = price;
        this.deletedCar = deletedCar;
    }

    public Car(String brand, String model, int yearOfIssue, double engineCapacity, int mileage, int price) {
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.engineCapacity = engineCapacity;
        this.mileage = mileage;
        this.price = price;
    }

    public Car(long id, String brand, String model, int yearOfIssue, double engineCapacity, int mileage, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.engineCapacity = engineCapacity;
        this.mileage = mileage;
        this.price = price;
    }

    public Car() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getDeletedCar() {
        return deletedCar;
    }

    public void setDeletedCar(boolean deletedCar) {
        this.deletedCar = deletedCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", engineCapacity=" + engineCapacity +
                ", mileage=" + mileage +
                ", price=" + price +
                ", deletedCar=" + deletedCar +
                '}';
    }
}
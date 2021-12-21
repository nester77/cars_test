package IG.test.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;

    @Column(name = "year_of_issue")
    @Temporal(TemporalType.DATE)
    private Date yearOfIssue;

    @Column(name = "engine_capacity")
    private double engineCapacity;

    private int mileage;

    private int price;

    @Column(name = "deleted_car")
    private boolean deletedCar;

    public Car(String brand, String model, Date yearOfIssue, double engineCapacity, int mileage, int price) {
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.engineCapacity = engineCapacity;
        this.mileage = mileage;
        this.price = price;
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

    public Date getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Date yearOfIssue) {
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

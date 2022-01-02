package IG.test.entity;

public class CarSearchCriteria {
    private String brand;
    private String model;
    private int yearOfIssueMin;
    private int yearOfIssueMax;
    private double engineCapacityMin;
    private double engineCapacityMax;
    private int mileageMax;
    private int priceMin;
    private int priceMax;

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

    public int getYearOfIssueMin() {
        return yearOfIssueMin;
    }

    public void setYearOfIssueMin(int yearOfIssueMin) {
        this.yearOfIssueMin = yearOfIssueMin;
    }

    public int getYearOfIssueMax() {
        return yearOfIssueMax;
    }

    public void setYearOfIssueMax(int yearOfIssueMax) {
        this.yearOfIssueMax = yearOfIssueMax;
    }

    public double getEngineCapacityMin() {
        return engineCapacityMin;
    }

    public void setEngineCapacityMin(double engineCapacityMin) {
        this.engineCapacityMin = engineCapacityMin;
    }

    public double getEngineCapacityMax() {
        return engineCapacityMax;
    }

    public void setEngineCapacityMax(double engineCapacityMax) {
        this.engineCapacityMax = engineCapacityMax;
    }

    public int getMileageMax() {
        return mileageMax;
    }

    public void setMileageMax(int mileageMax) {
        this.mileageMax = mileageMax;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }
}

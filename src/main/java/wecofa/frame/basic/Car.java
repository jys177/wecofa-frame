package wecofa.frame.basic;

import java.util.Date;

public class Car {

    private String carId;
    private String carName;
    private int price;
    private Date year;
    private String ownerId;

    public Car(String carId) {
        this.carId = carId;
    }

    public Car(String carId, String carName) {
        this.carId = carId;
        this.carName = carName;
    }

    public Car(String carId, String carName, int price) {
        this.carId = carId;
        this.carName = carName;
        this.price = price;
    }

    public Car(String carId, String carName, int price, Date year) {
        this.carId = carId;
        this.carName = carName;
        this.price = price;
        this.year = year;
    }

    public Car(String carId, String carName, int price, Date year, String ownerId) {
        this.carId = carId;
        this.carName = carName;
        this.price = price;
        this.year = year;
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", carName='" + carName + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}

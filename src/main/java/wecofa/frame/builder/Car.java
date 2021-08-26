package wecofa.frame.builder;

import java.util.Date;

public class Car {

    private final String carId;
    private final Date year;
    private final String carName;
    private final int price;
    private final String ownerId;

    public static class Builder{
        private final String carId;
        private final Date year;
        private String carName;
        private int price;
        private String ownerId;

        public Builder(String carId, Date year){
            this.carId = carId;
            this.year=year;
        }

        public Builder carName(String carName){
            this.carName = carName;
            return this;
        }

        public Builder price(int price){
            this.price=price;
            return this;
        }

        public Builder ownerId(String ownerId){
            this.ownerId=ownerId;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", year=" + year +
                ", carName='" + carName + '\'' +
                ", price=" + price +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }

    private Car(Builder builder){
        this.carId= builder.carId;
        this.year = builder.year;
        this.carName = builder.carName;
        this.price = builder.price;
        this.ownerId = builder.ownerId;
    }

}

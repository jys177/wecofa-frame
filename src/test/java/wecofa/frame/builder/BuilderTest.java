package wecofa.frame.builder;

import org.junit.Test;

import java.util.Date;

public class BuilderTest {
    @Test
    public void BasicConstructorType(){
        String carId="CAR-0001";
        Date year = new Date();
        String carName="SONATA";
        int price = 3000;
        String ownerId = "OWNER-0001";

        wecofa.frame.basic.Car car
                = new wecofa.frame.basic.Car(carId,carName,price,year,ownerId);
        System.out.println(car);
    }

    @Test
    public void builderTest(){
        String carId="CAR-0001";
        Date year = new Date();
        String carName="SONATA";
        int price = 3000;
        String ownerId = "OWNER-0001";

        Car car = new Car.Builder(carId,year)
                .price(price)
                .ownerId(ownerId)
                .carName(carName)
                .build();

        System.out.println(car);
    }

}

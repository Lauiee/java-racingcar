package racingcar.factory;

import static racingcar.factory.CarFactory.createCar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Cars;

public class CarsFactory {

    public static Cars createCars(List<String> carNames){
        Cars cars = new Cars();
        carNames.stream()
                .map(CarFactory::createCar)
                .forEach(cars::addCar);
        return cars;
    }
}

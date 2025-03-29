package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames){
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    public List<Car> getCars() {
        return cars;
    }

}

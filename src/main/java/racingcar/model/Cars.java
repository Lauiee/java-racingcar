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

    // 1회차 진행
    public void doRacing(){
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners(){
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

}

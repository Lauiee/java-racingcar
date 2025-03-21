package racingcar.view;

import static racingcar.view.ViewMessage.RACING_RESULT;
import static racingcar.view.ViewMessage.WINNER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public void printResultMessage(){
        System.out.println("\n"+RACING_RESULT);
    }

    public void printResult(Cars cars){
        StringBuilder result = new StringBuilder();
        for (Car car : cars.getCars()) {
            result.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        System.out.println(result);
    }

    public void printWinner(List<Car> winner) {
        System.out.print(WINNER);

        String result = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}

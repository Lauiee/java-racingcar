package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run(){

        // 경주 준비
        List<String> carNames = inputView.carsInput();
        int times = inputView.timesInput();

        Cars cars = Cars.from(carNames);

        // 경주 시작
        outputView.printResultMessage();
        for (int i = 0; i<times; i++){
            cars.doRacing();
            outputView.printResult(cars);
        }

        // 경주 결과
        List<Car> winners = cars.getWinners();
        outputView.printWinner(winners);
    }


}

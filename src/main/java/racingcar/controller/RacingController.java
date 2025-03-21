package racingcar.controller;

import java.util.List;
import racingcar.factory.CarsFactory;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.RacingService;
import racingcar.util.CarNameParser;
import racingcar.util.TimesParser;
import racingcar.validator.CarNamesValidation;
import racingcar.validator.TimesValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final RacingService racingService;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingController(RacingService racingService, OutputView outputView, InputView inputView) {
        this.racingService = racingService;
        this.outputView = outputView;
        this.inputView = inputView;

    }

    public void run(){

        // 경주 준비
        String input = inputView.carsInput();
        CarNamesValidation.validateAllInput(input);
        List<String> carNames = CarNameParser.parseCarName(input);
        carNames.forEach(CarNamesValidation::validateCarName);
        Cars cars = CarsFactory.createCars(carNames);

        String timeInput = inputView.timesInput();
        TimesValidation.validateAllInput(timeInput);
        int times = TimesParser.parseTimes(timeInput);

        // 경주 시작
        outputView.printResultMessage();
        for (int i = 0; i<times; i++){
            racingService.doRacing(cars);
            outputView.printResult(cars);
        }

        // 경주 결과
        List<Car> winner = racingService.getWinner(cars);
        outputView.printWinner(winner);
    }

}

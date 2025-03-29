package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingService racingService = new RacingService();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RacingController racingController = new RacingController(racingService, outputView, inputView);

        racingController.run();
    }
}

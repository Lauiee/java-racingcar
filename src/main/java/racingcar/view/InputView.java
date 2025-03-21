package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String carsInput() {
        return readInput(ViewMessage.INPUT_CAR_NAME.toString());
    }

    public String timesInput() {
        return readInput(ViewMessage.INPUT_TIMES.toString());
    }

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}

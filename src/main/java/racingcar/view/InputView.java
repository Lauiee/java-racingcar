package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ErrorMessage;

public class InputView {

    public String carsInput() {
        String input = readInput(ViewMessage.INPUT_CAR_NAME.getMessage());
        validateDelimiter(input);
        validateBetweenDelimiter(input);
        return input;
    }

    public int timesInput() {
        String input = readInput(ViewMessage.INPUT_TIMES.getMessage());
        validateCharacter(input);
        int times = Integer.parseInt(input);
        validateZeroOrNegative(times);
        return times;
    }

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private void validateDelimiter(String input) {
        // 쉼표(,)로 나누었을 때, 쉼표 이외의 문자가 포함되어 있으면 예외 처리
        if (!input.replaceAll(" ","").matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DELIMITER_ONLY_COMMA.getMessage());
        }
    }

    private void validateBetweenDelimiter(String input) {
        String[] cars = input.split(",",-1); // -1을 limit으로 넣어주어 문자열의 마지막이 구분자인 경우도 검출
        for (String car: cars){
            throwIfEmpty(car.trim().isEmpty());
        }
    }

    private void throwIfEmpty(boolean state){
        if (state){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER.getMessage());
        }
    }


    private void validateCharacter(final String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_ONLY_DIGIT.getMessage());
        }
    }

    private void validateZeroOrNegative(final int times) {
        if (times <= 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_ONLY_POSITIVE.getMessage());
        }
    }

    private boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

}

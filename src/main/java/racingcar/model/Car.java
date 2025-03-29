package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.ErrorMessage;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_EMPTY_OR_NULL.getMessage());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NAME_OVER_FIVE.getMessage());
        }
        if (!name.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_ONLY_ENG.getMessage());
        }
        this.name = name.trim();
        this.position = 0;
    }

    public void move(){
        if (isMove()){
            position++;
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }
}

package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingService {

    // 1회차 진행
    public void doRacing(Cars cars){
        for (Car car : cars.getCars()) {
            if(isMove()) car.move();
        }
    }

    // 전진 여부 판단 메서드
    private boolean isMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    // 우승자 선정
    public List<Car> getWinner(Cars cars){
        int topPosition = getTopPosition(cars);

        List<Car> winners = new ArrayList<>();

        for (Car car : cars.getCars()) {
            if (car.isWinner(topPosition)) winners.add(car);
        }

        return winners;
    }

    // 가장 멀리간 위치 측정
    private int getTopPosition(Cars cars){
        int currentTopPosition = 0;

        for (Car car : cars.getCars()) {
            currentTopPosition = car.updateTopPosition(currentTopPosition);
        }

        return currentTopPosition;
    }
}

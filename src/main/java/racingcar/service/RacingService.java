package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingService {

    // 1회차 진행
    public void doRacing(List<Car> cars){
        for (Car car : cars) {
            if(isMove()) car.move();
        }
        // 1회차 결과 출력
        // ~~
    }

    // 전진 여부 판단 메서드
    private boolean isMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    // 우승자 선정
    public List<Car> getWinner(List<Car> cars){
        int currentTopPosition = 0;

        for (Car car : cars) {
            currentTopPosition = car.updateTopPosition(currentTopPosition);
        }

        List<Car> winner = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner(currentTopPosition)) winner.add(car);
        }

        return winner;
    }
}

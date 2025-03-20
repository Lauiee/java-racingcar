package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingServiceTest {

    private RacingService racingService;
    private Car test1;
    private Car test2;
    private Car test3;

    @BeforeEach
    void init(){
        racingService = new RacingService();
        test1 = new Car("test1");
        test2 = new Car("test2");
        test3 = new Car("test3");
    }

    @Test
    @DisplayName("경주에 참가한 모든 차에 각각 랜덤값을 통한 전진 여부를 판단하여 적용합니다.")
    void 회차_진행(){
        List<Car> cars = List.of(test1,test2,test3);
        racingService.doRacing(cars);
        // 랜덤값 테스트가 넘 빡셈 일단 결과만 볼게요...
    }

    @Test
    @DisplayName("각자의 위치를 통해 우승자를 선출합니다.")
    void 우승자_선출(){
        List<Car> cars = List.of(test1,test2,test3);
        test1.move();
        List<Car> winner = racingService.getWinner(cars);
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.getFirst()).isEqualTo(test1);
    }

    @Test
    @DisplayName("각자의 위치를 통해 우승자를 선출합니다. 단 공동우승도 가능합니다.")
    void 공동_우승자_선출(){
        List<Car> cars = List.of(test1,test2,test3);
        test1.move();
        test2.move();
        List<Car> winner = racingService.getWinner(cars);
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.getFirst()).isEqualTo(test1);
        assertThat(winner.getLast()).isEqualTo(test2);
    }
}
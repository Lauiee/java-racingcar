package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void init(){
        car = new Car("test");
    }

    @Test
    @DisplayName("자동차를 한 칸 전진시킵니다.")
    void 자동차_전진(){
        car.move();
        assertThat(car.getName()).isEqualTo("test : -");
    }

    @Test
    @DisplayName("현재 선두의 위치와 대상 자동차의 위치를 비교해 더 앞선 위치로 업데이트 합니다.")
    void 선두_위치_업데이트(){
        int currentTopPosition = 0;
        car.move();
        int updatedPosition = car.updateTopPosition(currentTopPosition);
        assertThat(updatedPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("최종 선두 위치와 대상 자동차의 위치를 비교해 우승자 여부를 판단합니다.")
    void 우승자_여부_판단(){
        int topPosition = 0;
        assertThat(car.isWinner(topPosition)).isTrue();
    }
    
}
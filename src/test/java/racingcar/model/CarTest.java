package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void init(){
        car = new Car();
    }

    @Test
    @DisplayName("자동차를 한 칸 전진시킵니다.")
    void move(){
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
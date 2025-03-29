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
    
}
package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputView inputView = new InputView();

    @DisplayName("정상 입력을 받으면 해당 줄을 읽어옴, 자동차 이름 문자열")
    @ParameterizedTest
    @ValueSource(strings = {"ian,delta", "ian, delta, peter", "kevin, ian, peter, rion"})
    void 정상_입력_자동차_이름(String input){
        // Given
        systemIn(input);

        // When
        List<String> result = inputView.carsInput();

        // Then
        List<String> expected = Arrays.asList(input.split(",\\s*"));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("정상 입력을 받으면 해당 줄을 읽어옴, 실행 횟수 문자열")
    @ParameterizedTest
    @ValueSource(strings = {"1", "21", "1024"})
    void 정상_입력_실행_횟수(String input){
        // Given
        systemIn(input);
        // When
        int result = inputView.timesInput();
        // then
        Assertions.assertThat(String.valueOf(result)).isEqualTo(input);
    }

    @AfterEach
    void closeConsole(){
        Console.close();
    }

    private void systemIn(final String input){
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

}
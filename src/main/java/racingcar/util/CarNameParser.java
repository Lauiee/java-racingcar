package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public static List<String> parseCarName(String input) {
        return Arrays.stream(input.replaceAll(" ","").split(",")).toList();
    }
}

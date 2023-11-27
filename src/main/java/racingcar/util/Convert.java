package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Convert {

    private static final String COMMA = ",";

    public static List<String> StringToListByComma(String input) {
        return Arrays.asList(input.split(COMMA));
    }
}

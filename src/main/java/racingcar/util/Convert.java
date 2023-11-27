package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Convert {

    private static final String COMMA = ",";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";

    public static List<String> StringToListByComma(String input) {
        return Arrays.asList(input.split(COMMA));
    }

    public static int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}

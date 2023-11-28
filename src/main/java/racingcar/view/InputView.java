package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.util.Convert;

public class InputView {

    private static final String RACING_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(RACING_CAR_NAMES_INPUT_MESSAGE);
        return readLine();
    }

    public int readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        String input = readLine();
        return Convert.StringToInt(input);
    }
}

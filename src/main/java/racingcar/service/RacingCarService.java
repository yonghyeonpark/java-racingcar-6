package racingcar.service;

import java.util.List;
import racingcar.model.Score;

public class RacingCarService {

    private static final int MOVING_STANDARD = 4;
    private static final String WINNERS_FORMAT = "최종 우승자 : ";
    private static final String COMMA_AND_SPACE = ", ";

    private final Score score;

    public RacingCarService(List<String> cars) {
        this.score = new Score(cars);
    }

    public void checkMoveForward(int num, String carName) {
        if (num >= MOVING_STANDARD) {
            score.addMoving(carName);
        }
    }

    public String getOneAttemptResult() {
        return score.toString();
    }

    public String getWinners() {
        List<String> winners = score.pickWinners();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WINNERS_FORMAT)
                .append(String.join(COMMA_AND_SPACE, winners));
        return stringBuilder.toString();
    }
}

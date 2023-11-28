package racingcar.service;

import java.util.List;
import racingcar.model.Score;

public class RacingCarService {

    private static final int MOVING_STANDARD = 4;

    private final Score score;

    public RacingCarService(List<String> cars) {
        this.score = new Score(cars);
    }

    public void checkMoveForward(int num, String carName) {
        if (num >= MOVING_STANDARD) {
            score.addMoving(carName);
        }
    }
}

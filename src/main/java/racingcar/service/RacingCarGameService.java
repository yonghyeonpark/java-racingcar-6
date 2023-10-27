package racingcar.service;

public class RacingCarGameService {

    private static final int MOVING_FORWARD_STANDARD = 4;

    public boolean isMovingForward(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD_STANDARD) {
            return true;
        }
        return false;
    }
}

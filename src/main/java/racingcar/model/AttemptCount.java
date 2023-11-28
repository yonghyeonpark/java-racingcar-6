package racingcar.model;

public class AttemptCount {

    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final String ATTEMPT_COUNT_RANGE_ERROR_MESSAGE = "[ERROR] 입력할 수 있는 최소 시도 횟수는 1입니다.";

    private final int attemptCount;

    public AttemptCount(int attemptCount) {
        validateRange(attemptCount);
        this.attemptCount = attemptCount;
    }

    private void validateRange(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}

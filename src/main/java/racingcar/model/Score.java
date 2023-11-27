package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENTAL_VALUE = 1;
    private static final String CAR_MOVING_RESULT_FORMAT = " : ";
    private static final String MOVING = "-";

    private final LinkedHashMap<String, Integer> score;

    public Score(List<String> cars) {
        this.score = new LinkedHashMap<>();
        setUp(cars);
    }

    private void setUp(List<String> cars) {
        for (String car : cars) {
            score.put(car, INITIAL_VALUE);
        }
    }

    public void addMoving(String carName) {
        score.put(carName, score.get(carName) + INCREMENTAL_VALUE);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(CAR_MOVING_RESULT_FORMAT);
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(MOVING);
            }
        }
        return stringBuilder.toString();
    }
}

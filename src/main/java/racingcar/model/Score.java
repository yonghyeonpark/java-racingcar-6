package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENTAL_VALUE = 1;

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
}

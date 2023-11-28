package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.Convert;

public class Cars {

    private static final int MAX_CARS_NUMBER = 8;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private static final String CARS_SIZE_ERROR_MESSAGE = "[ERROR] 참가 자동차의 수의 범위는 1~8입니다.";
    private static final String CAR_NAME_RANGE_ERROR_MESSAGE = "[ERROR] 자동차 이름의 범위는 1~5자입니다.";
    private static final String CAR_NAMES_DUPLICATE_MESSAGE = "[ERROR] 자동차의 이름은 중복될 수 없습니다.";

    private final List<String> cars;

    public Cars(String inputCars) {
        this.cars = convertAndValidate(inputCars);
    }

    private List<String> convertAndValidate(String inputCars) {
        List<String> cars = Convert.StringToListByComma(inputCars);
        validateSize(cars);
        validateNameLength(cars);
        validateDuplicate(cars);
        return cars;
    }

    private void validateSize(List<String> cars) {
        if (cars.size() > MAX_CARS_NUMBER) {
            throw new IllegalArgumentException(CARS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > MAX_CAR_NAME_LENGTH || car.isBlank()) {
                throw new IllegalArgumentException(CAR_NAME_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicate(List<String> cars) {
        Set<String> duplicateCheck = new HashSet<>(cars);
        if (duplicateCheck.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_MESSAGE);
        }
    }

    public List<String> getCars() {
        return cars;
    }
}

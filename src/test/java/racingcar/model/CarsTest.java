package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @DisplayName("경주에 참가하는 차가 8대를 넘기거나 2대보다 적으면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 자동차 이름 입력값 = {arguments}")
    @ValueSource(strings = {"car1", "car1,car2,car3,car4,car5,car6,car7,car8,car9"})
    void should_ThrowException_When_CarsSizeOverEightOrUnderTwo(String inputCarNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(inputCarNames))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("자동차 이름이 5자를 넘기거나 공백이면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 자동차 이름 입력값 = {arguments}")
    @ValueSource(strings = {"car123", "", " "})
    void should_ThrowException_When_CarNameLengthOverFiveOrBlank(String inputCarNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(inputCarNames))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_CarNamesDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars("car1,car1,car2"))
                .withMessageContaining("[ERROR]");
    }
}

package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountTest {

    @DisplayName("시도 횟수가 1보다 작으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_AttemptCountUnderOne() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new AttemptCount(0))
                .withMessageContaining("[ERROR]");
    }
}

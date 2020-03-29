package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
public class RepeatTest implements BaseTest {

    @DisplayName("반복테스트")
    @RepeatedTest(5)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        log.info("repeatedTest(): {}/{}", repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions());
        assertLimitIsGreaterThan0();
    }

    @DisplayName("반복테스트 2")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatedTest2(RepetitionInfo repetitionInfo) {
        log.info("repeatedTest2(): {}/{}", repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions());
        assertLimitIsGreaterThan0();
    }

    @DisplayName("파라미터 입력 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    void parameterizedTest(String message) {
        log.info("message: {}", message);
    }
}

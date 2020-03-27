package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import java.time.Duration;

import static inflearn.whiteship.thejavatest.Study.ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Slf4j
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AssumeTest implements BaseTest {

    @Test
    @DisplayName("assumeTrue()")
    void test_assumeTrue() {
        String testEnv = System.getenv("TEST_ENV");
        log.info("testEnv: {}", testEnv);

        // assumeTrue() 메소드의 파라미터가 참 이어야 다음 테스트 코드들을 수행함.
        // 거짓인 경우에는 테스트가 그대로 종료됨.

        // 테스트 수행
        assumeTrue("LOCAL".equalsIgnoreCase(testEnv));

        // 테스트 미수행
        //assumeTrue("QA".equalsIgnoreCase(testEnv));

        assertStudyIsNotNull();

        log.info("assumeTrue()");
    }


    @Test
    @DisplayName("assumingThat()")
    void test_assumingThat() {
        String testEnv = System.getenv("TEST_ENV");
        log.info("testEnv: {}", testEnv);

        // 조건식에 따른 테스트 분기 수행
        assumingThat("LOCAL".equalsIgnoreCase(testEnv), () -> {
            log.info("LOCAL");
            assertStudyIsNotNull();
        });

        assumingThat("QA".equalsIgnoreCase(testEnv), () -> {
            log.info("QA");
            Study study = new Study(10);
            assertThat(study.getLimit()).isGreaterThan(0);
        });

        log.info("assumingThat()");
    }
}
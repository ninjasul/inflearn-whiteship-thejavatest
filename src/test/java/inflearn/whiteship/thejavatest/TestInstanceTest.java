package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.time.Duration;

import static inflearn.whiteship.thejavatest.Study.ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
class TestInstanceTest {

    int value = 1;

    @Test
    @DisplayName("method1")
    void method1() {
        log.info("value: {}", ++value);
        log.info("method1");
    }

    @Test
    @DisplayName("method2")
    void method2() {
        log.info("value: {}", ++value);
        log.info("method2");
    }


    // 테스트 인스턴스가 Lifecycle.PER_CLASS 인 경우 BeforeAll, AfterAll 메소드가 static일 필요가 없음.
    @BeforeAll
    void beforeAll() {
        log.info("beforeAll");
    }

    @AfterAll
    void afterAll() {
        log.info("afterAll");
    }

    @BeforeEach
    void setUp() {
        log.info("beforeEach");
    }

    @AfterEach
    void tearDown() {
        log.info("afterEach");
    }
}
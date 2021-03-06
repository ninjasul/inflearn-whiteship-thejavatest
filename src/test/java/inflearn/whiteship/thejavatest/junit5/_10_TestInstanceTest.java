package inflearn.whiteship.thejavatest.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
class _10_TestInstanceTest {

    int value = 1;

    @Test
    @DisplayName("method1")
    void method1() {
        log.info("value: {}", value++);
        log.info("method1");
    }

    @Test
    @DisplayName("method2")
    void method2() {
        log.info("value: {}", value++);
        log.info("method2");
    }


    // 테스트 인스턴스가 Lifecycle.PER_CLASS 인 경우 BeforeAll, AfterAll 메소드가 static일 필요가 없음.
    @BeforeAll
    static void beforeAll() {
        log.info("beforeAll");
    }

    @AfterAll
    static void afterAll() {
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
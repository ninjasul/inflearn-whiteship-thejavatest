package inflearn.whiteship.thejavatest.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class _12_TestMethodOrder {
    private int value = 1;

    @Test
    @DisplayName("method2")
    @Order(2)
    void method2() {
        log.info("value: {}", value++);
        log.info("method2");
    }

    @Test
    @DisplayName("method3")
    @Order(3)
    void method3() {
        log.info("value: {}", value++);
        log.info("method3");
    }

    @Test
    @DisplayName("method1")
    @Order(1)
    void method1() {
        log.info("value: {}", value++);
        log.info("method1");
    }
}
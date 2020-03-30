package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;

@Slf4j
// @ExtendWith 는 대상 Extension 클래스를 기본 생성자로만 생성할 수 있음.
@ExtendWith(FindTestBExtension.class)
class _13_Junit5Extensions_ExtendWith {

    @Test
    @DisplayName("method1")
    void method1() {
        log.info("method1");
    }

    @Test
    @DisplayName("method2")
    void method2() throws InterruptedException {
        Thread.sleep(1000L);
        log.info("method2");
    }

    @Test
    @DisplayName("method3")
    void method3() {
        log.info("method3");
    }
}
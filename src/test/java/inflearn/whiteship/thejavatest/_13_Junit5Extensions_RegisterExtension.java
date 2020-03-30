package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@Slf4j
class _13_Junit5Extensions_RegisterExtension {

    @RegisterExtension
    static FindTestBExtension findTestBExtension = new FindTestBExtension(500);

    @Test
    @DisplayName("method1")
    void method1() {
        log.info("method1");
    }

    @Test
    @DisplayName("method2")
    void method2() {
        log.info("method2");
    }

    @Test
    @DisplayName("method3")
    void method3() throws InterruptedException {
        Thread.sleep(800L);
        log.info("method3");
    }
}
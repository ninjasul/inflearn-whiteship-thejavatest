package inflearn.whiteship.thejavatest;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Slf4j
public class TagTest implements BaseTest {

    @Test
    @Tag("A")
    void test_tagA() {
        assertLimitIsGreaterThan0();
        log.info("test_tagA()");
    }

    @Test
    @Tag("B")
    void test_tagB() {
        assertStudyIsNotNull();
        log.info("test_tagB()");
    }
}

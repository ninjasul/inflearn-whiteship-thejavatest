package inflearn.whiteship.thejavatest.junit5;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _06_CustomTagTest implements BaseTest {

    @TestA
    void test_tagA() {
        assertLimitIsGreaterThan0();
        log.info("test_tagA()");
    }

    @TestB
    void test_tagB() {
        assertStudyIsNotNull();
        log.info("test_tagB()");
    }
}

package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static inflearn.whiteship.thejavatest.Study.ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create() {
        Study study = new Study();
        assertNotNull(study);
        log.info("create");
    }

    @Test
    @Disabled
    @DisplayName("스터디 만들기1")
    void create1() {
        log.info("create1");
    }

    @Test
    @DisplayName("assertEquals()")
    void test_assertEquals() {
        Study study = new Study();
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT이어야 함.");
        log.info("assertEquals()");
    }

    @Test
    @DisplayName("assertAll()")
    void test_assertAll() {
        Study study = new Study(10);

        // 테스트를 순차적으로 수행하는 것이 아니라 모두 수행함. 2개 이상 실패되면 해당 실패메시지를 모두 보여줌.
        assertAll(
                () -> assertThat(study).isNotNull(),
                () -> assertThat(study.getStatus()).isEqualTo(StudyStatus.DRAFT),
                () -> assertThat(study.getLimit()).isGreaterThan(0)
        );

        log.info("assertAll()");
    }

    @Test
    @DisplayName("assertThrows()")
    void test_assertThrows() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-5));
        assertThat(exception.getMessage()).isEqualTo(ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0);
        log.info("assertThrows()");
    }

    @Test
    @DisplayName("assertTimeout()")
    void test_assertTimeout() {

        // assertTimeout() 는 테스트 코드를 끝까지 수행한 다음, 성공, 실패 여부를 판단함.
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            //Thread.sleep(300);
        });

        log.info("assertTimeout()");
    }

    @Test
    @DisplayName("assertTimeoutPreemptively()")
    void test_assertTimeoutPreemtively() {

        // assertTimeoutPreemptively() 는 별도 스레드 생성 후 timout이 발생하면 바로 종료함.
        // 별도 스레드를 생성하므로 ThreadLocal 을 사용하는 테스트 코드는 오동작을 일으킬 수 있으므로 유의해야 함.
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            //Thread.sleep(300);
        });

        log.info("assertTimeoutPreemptively()");
    }

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
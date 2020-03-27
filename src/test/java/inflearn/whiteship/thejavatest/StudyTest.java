package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

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
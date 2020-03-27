package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Slf4j
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EnabledTest {

    @Test
    @EnabledOnOs({OS.MAC})
    @DisplayName("EnabledOnOs")
    void test_EnabledOnOs() {
        assertStudyIsNotNull();
        log.info("test_EnabledOnOs()");
    }

    @Test
    @DisabledOnOs({OS.MAC})
    @DisplayName("DisabledOnOs")
    void test_DisabledOnOs() {
        assertStudyIsNotNull();
        log.info("test_DisabledOnOs()");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    @DisplayName("EnabledOnJre")
    void test_EnabledOnJRE() {
        assertStudyIsNotNull();
        log.info("test_EnabledOnJRE()");
    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    @DisplayName("DisabledOnJre")
    void test_DisabledOnJre() {
        assertStudyIsNotNull();
        log.info("test_DisabledOnJre()");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    @DisplayName("EnabledIfEnvironmentVariable")
    void test_EnabledIfEnvironmentVariable() {
        assertStudyIsNotNull();
        log.info("test_EnabledIfEnvironmentVariable()");
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    @DisplayName("DisabledIfEnvironmentVariable")
    void test_DisabledIfEnvironmentVariable() {
        assertStudyIsNotNull();
        log.info("test_DisabledIfEnvironmentVariable()");
    }

    @Test
    @EnabledIfSystemProperty(named = "TEST_SYS_PROPERTY", matches = "NINJASUL")
    @DisplayName("EnabledIfSystemProperty")
    void test_EnabledIfSystemProperty() {
        assertStudyIsNotNull();
        log.info("test_EnabledIfSystemProperty()");
    }

    @Test
    @DisabledIfSystemProperty(named = "TEST_SYS_PROPERTY", matches = "NINJASUL")
    @DisplayName("DisabledIfSystemProperty")
    void test_DisabledIfSystemProperty() {
        assertStudyIsNotNull();
        log.info("test_DisabledIfSystemProperty()");
    }

    private void assertStudyIsNotNull() {
        Study study = new Study(10);
        assertThat(study).isNotNull();
    }
}
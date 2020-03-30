package inflearn.whiteship.thejavatest.junit5;

import inflearn.whiteship.thejavatest.domain.Study;

import static org.assertj.core.api.Assertions.assertThat;

public interface BaseTest {
    default void assertStudyIsNotNull() {
        Study study = new Study(10);
        assertThat(study).isNotNull();
    }

    default void assertLimitIsGreaterThan0() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }
}

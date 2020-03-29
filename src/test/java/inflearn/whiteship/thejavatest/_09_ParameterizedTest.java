package inflearn.whiteship.thejavatest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class _09_ParameterizedTest {

    @DisplayName("파라미터 입력 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @NullAndEmptySource
    void parameterizedTest(String message) {
        log.info("message: {}", message);
    }

    @DisplayName("simpleArgumentConverter 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20, 40})
    void simpleArgumentConverterTest(@ConvertWith(StudyConverter.class) Study study) {
        log.info("limit: {}", study.getLimit());

        assertThat(study).isNotNull();
    }

    // 하나의 파라미터 입력 받아 객체로 변환 해 주는 클래스
    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @DisplayName("Arguments 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바스터디'", "20, '스프링 스터디'"})
    void argumentsTest(Integer limit, String name) {
        Study study = new Study(limit, name);

        assertThat(study).isNotNull();
        assertThat(study.getLimit()).isEqualTo(limit);
        assertThat(study.getName()).isEqualTo(name);

        log.info("study: {}", study);
    }

    @DisplayName("ArgumentsAccessor 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바스터디'", "20, '스프링 스터디'"})
    void argumentAccessorTest(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));

        assertThat(study).isNotNull();
        assertThat(study.getLimit()).isEqualTo(argumentsAccessor.getInteger(0));
        assertThat(study.getName()).isEqualTo(argumentsAccessor.getString(1));

        log.info("study: {}", study);
    }

    @DisplayName("ArgumentsAggregator 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바스터디'", "20, '스프링 스터디'"})
    void argumentsAggregatorTest(@AggregateWith(StudyAggregator.class) Study study) {
        assertThat(study).isNotNull();

        log.info("study: {}", study);
    }

    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }
}

package inflearn.whiteship.thejavatest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.annotation.Annotation;
import java.util.Objects;

@Slf4j
@NoArgsConstructor
public class FindTestBExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private long threshold = 1000L;

    public FindTestBExtension(long threshold) {
        this.threshold = threshold;
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        ExtensionContext.Store store = getStore(context);
        store.put("START_TIME", System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (getDuration(getStore(context)) > threshold &&
                Objects.isNull(getAnnotation(context, TestB.class))) {
            log.info("Please consider marking method [{}] with @TestB.\n", getTestMethodName(context));
        }
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        String testClassName = context.getRequiredTestClass().getName();
        String testMethodName = getTestMethodName(context);
        return context.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
    }

    private String getTestMethodName(ExtensionContext context) {
        return context.getRequiredTestMethod().getName();
    }

    private long getDuration(ExtensionContext.Store store) {
        long startTime = store.remove("START_TIME", long.class);
        return System.currentTimeMillis() - startTime;
    }

    private <T extends Annotation> T getAnnotation(ExtensionContext context, Class<T> annotationClass) {
        return context.getRequiredTestMethod().getAnnotation(annotationClass);
    }
}

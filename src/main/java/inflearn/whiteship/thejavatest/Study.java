package inflearn.whiteship.thejavatest;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Study {
    static final String ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0 = "참여인원은 1명 이상이어야 합니다.";

    private StudyStatus status = StudyStatus.DRAFT;
    private int limit;
    private String name;

    public Study(int limit) {
        assertLimitIsGreaterThanZero(limit);
        this.limit = limit;
    }

    public Study(int limit, String name) {
        assertLimitIsGreaterThanZero(limit);
        this.limit = limit;
        this.name = name;
    }

    private void assertLimitIsGreaterThanZero(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0);
        }
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}

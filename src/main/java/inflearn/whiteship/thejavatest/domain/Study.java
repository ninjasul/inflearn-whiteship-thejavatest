package inflearn.whiteship.thejavatest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Study {
    public static final String ERROR_MESSAGE_LIMIT_SHOULD_BE_GREATER_THAN_0 = "참여인원은 1명 이상이어야 합니다.";

    private StudyStatus status = StudyStatus.DRAFT;
    private int limit;
    private String name;
    private LocalDateTime openedDateTime;
    private Long ownerId;

    public Study(int limit) {
        assertLimitIsGreaterThanZero(limit);
        this.limit = limit;
    }

    @Builder
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

    public void open() {
        this.openedDateTime = LocalDateTime.now();
        this.status = StudyStatus.OPENED;
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

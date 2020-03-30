package inflearn.whiteship.thejavatest.mockito;

import inflearn.whiteship.thejavatest.member.MemberService;
import inflearn.whiteship.thejavatest.study.StudyRepository;
import inflearn.whiteship.thejavatest.study.StudyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class StudyServiceMockitoTest {
    @Mock
    private MemberService annotatedMemerService;

    @Mock
    private StudyRepository annotatedRepository;

    @Test
    void annotatedMockitoTest() {
        StudyService studyService = new StudyService(annotatedMemerService, annotatedRepository);
        assertThat(studyService).isNotNull();
    }

    @Test
    void parameterizedMockitoTest(@Mock MemberService paramMemberService,
                                  @Mock StudyRepository paramStudyService) {
        StudyService studyService = new StudyService(paramMemberService, paramStudyService);
        assertThat(studyService).isNotNull();
    }
}

package inflearn.whiteship.thejavatest.mockito;

import inflearn.whiteship.thejavatest.member.MemberService;
import inflearn.whiteship.thejavatest.study.StudyRepository;
import inflearn.whiteship.thejavatest.study.StudyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = StudyService.class)
public class StudyServiceTest {
    @MockBean
    private MemberService memberService;

    @MockBean
    private StudyRepository studyRepository;

    @Test
    void createStudyService() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertThat(studyService).isNotNull();
    }
}

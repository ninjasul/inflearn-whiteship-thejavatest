package inflearn.whiteship.thejavatest.mockito;

import inflearn.whiteship.thejavatest.domain.Member;
import inflearn.whiteship.thejavatest.domain.Study;
import inflearn.whiteship.thejavatest.member.MemberService;
import inflearn.whiteship.thejavatest.study.StudyRepository;
import inflearn.whiteship.thejavatest.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class _21_BDDStyledTest {

    @Mock
    private MemberService memberService;

    @Mock
    private StudyRepository studyRepository;

    @Test
    @DisplayName("verify() 테스트")
    void test_verify() {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertThat(studyService).isNotNull();
        Member member = createMember();
        Study study = createStudy();

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.createNewStudy(1L, study);

        // Then
        assertThat(study.getOwnerId()).isNotNull();
        assertThat(member.getId()).isEqualTo(study.getOwnerId());

        then(memberService).should(times(1)).notify(study);
        then(memberService).should(times(1)).notify(member);
        then(memberService).should(never()).validate(any());
        then(memberService).shouldHaveNoMoreInteractions();
    }

    private Member createMember() {
        return Member.builder()
                .id(1L)
                .email("ninjasul@gmail.com")
                .build();
    }

    private Study createStudy() {
        return Study.builder()
                .limit(10)
                .name("Java Study")
                .build();
    }

}

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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class _21_VerifyTest {

    @Mock
    private MemberService memberService;

    @Mock
    private StudyRepository studyRepository;

    @Test
    @DisplayName("verify() 테스트")
    void test_verify() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertThat(studyService).isNotNull();

        Member member = createMember();
        Study study = createStudy();

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        assertThat(study.getOwnerId()).isNotNull();
        assertThat(member.getId()).isEqualTo(study.getOwnerId());

        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);
        verify(memberService, never()).validate(any());
    }

    @Test
    @DisplayName("InOrder 테스트")
    void test_InOrder() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertThat(studyService).isNotNull();

        Member member = createMember();
        Study study = createStudy();

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).notify(member);
        verifyNoMoreInteractions(memberService);
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

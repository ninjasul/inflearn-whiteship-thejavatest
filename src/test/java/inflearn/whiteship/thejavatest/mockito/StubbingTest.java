package inflearn.whiteship.thejavatest.mockito;

import inflearn.whiteship.thejavatest.domain.Member;
import inflearn.whiteship.thejavatest.domain.Study;
import inflearn.whiteship.thejavatest.member.MemberService;
import inflearn.whiteship.thejavatest.study.StudyRepository;
import inflearn.whiteship.thejavatest.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StubbingTest {

    @Mock
    private MemberService memberService;

    @Mock
    private StudyRepository studyRepository;

    @Test
    void memberServiceTest() {
        assertThat(memberService).isNotNull();
        assertThat(memberService.findById(1L)).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("optional 리턴 메소드 테스트")
    void optionalTest() {
        assertThat(memberService).isNotNull();
        assertThat(memberService.findById(1L)).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("void 리턴 메소드 테스트")
    void test_void() {
        // void 리턴 메소드는 오류를 발생시키지 않음.
        memberService.validate(1L);
    }

    @Test
    @DisplayName("findById 테스트")
    void test_findById() {
        Member member = createMember();

        when(memberService.findById(anyLong())).thenReturn(Optional.of(member));

        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "Java Study");


        Member foundMember = memberService.findById(1L).get();
        assertThat(foundMember).isEqualTo(member);
    }

    private Member createMember() {
        return Member.builder()
                .id(1L)
                .email("ninjasul@gmail.com")
                .build();
    }

}

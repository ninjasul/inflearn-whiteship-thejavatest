package inflearn.whiteship.thejavatest.member;

import inflearn.whiteship.thejavatest.domain.Study;
import inflearn.whiteship.thejavatest.domain.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId);
    void validate(Long memberId);
    void notify(Study newStudy);
    void notify(Member member);
}

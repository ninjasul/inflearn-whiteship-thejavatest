package inflearn.whiteship.thejavatest.study;

import inflearn.whiteship.thejavatest.domain.Member;
import inflearn.whiteship.thejavatest.domain.Study;
import inflearn.whiteship.thejavatest.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyService {
    private final MemberService memberService;
    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        assert memberService != null;
        assert repository != null;

        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);

        if (member.isPresent()) {
            study.setOwnerId(memberId);
        }
        else {
            throw new IllegalArgumentException(String.format("Member doesn't exist for id: '%ld'", memberId));
        }

        Study newStudy = repository.save(study);
        //memberService.notify(newStudy);
        return newStudy;
    }

    public Study openStudy(Study study) {
        study.open();
        Study openedStudy = repository.save(study);
        memberService.notify(openedStudy);
        return openedStudy;
    }

}

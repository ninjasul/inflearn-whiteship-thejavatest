package inflearn.whiteship.thejavatest.study;

import inflearn.whiteship.thejavatest.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}

package inflearn.whiteship.thejavatest.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String email;

    public Member(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}

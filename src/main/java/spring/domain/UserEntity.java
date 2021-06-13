package spring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="userid", length = 45)
    String userid;

    @Column(name="userapssword", length = 45)
    String userpassword;

    @Column(name="username", length = 45)
    String username;

    @Builder
    public UserEntity(int id, String userid, String userpassword, String username) {
        this.id = id;
        this.userid = userid;
        this.userpassword = userpassword;
        this.username = username;
    }
}

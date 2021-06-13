package spring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Getter
public class PostEntity {

    @Id
    @Column(name = "postkey", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int poskey;

    @Column(name="title", length = 45)
    String title;

    @Column(name="contents", length = 100)
    String contents;


    @Builder
    public PostEntity(int postkey, String title, String contents) {
        this.poskey = postkey;
        this.title = title;
        this.contents= contents;
    }

    //업데이트 메소드
    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}

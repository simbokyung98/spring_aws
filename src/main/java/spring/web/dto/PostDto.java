package spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.domain.PostEntity;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private int postkey;
    private String title;
    private String contents;

    @Builder
    public PostDto(int postkey, String title, String contents){
        this.postkey = postkey;
        this.title = title;
        this.contents = contents;
    }

    public PostEntity toEntity(){
        return PostEntity.builder()
                .title(title)
                .contents(contents).build();
    }
}

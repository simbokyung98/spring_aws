package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.PostEntity;
import spring.domain.PostRepository;
import spring.web.dto.PostDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Integer save(PostDto dto){
        return postRepository.save(dto.toEntity()).getPoskey();
    }

    public List<PostDto> getAllPost(){
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();

        for(PostEntity postEntity:postEntities){
            PostDto postDto = PostDto.builder()
                    .postkey(postEntity.getPoskey())
                    .title(postEntity.getTitle())
                    .contents(postEntity.getContents()).build();
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    public PostDto getPost(int postkey){
        Optional<PostEntity> optionalPostEntity = postRepository.findById(postkey);
        PostEntity postEntity = optionalPostEntity.get();

        PostDto postDto = PostDto.builder()
                .postkey(postEntity.getPoskey())
                .title(postEntity.getTitle())
                .contents(postEntity.getContents()).build();
        return postDto;
    }
    @Transactional
    public void updatepost(int postkey, PostDto postDto) {
        Optional<PostEntity> optionalPostEntity = postRepository.findById(postkey);

        PostEntity postEntity = optionalPostEntity.get();

        postEntity.update(postDto.getTitle(), postDto.getContents());
    }
    @Transactional
    public void delPost(int postkey) {
        Optional<PostEntity> optionalPostEntity = postRepository.findById(postkey);
        PostEntity postEntity = optionalPostEntity.get();

        postRepository.delete(postEntity);
    }
}

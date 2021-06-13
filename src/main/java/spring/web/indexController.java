package spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.service.PostService;
import spring.web.dto.PostDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class indexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        List<PostDto> postDtoList = postService.getAllPost();

        model.addAttribute("postlist", postDtoList);
        return "index";
    }

    @GetMapping("/index")
    public String reindex(Model model){
        List<PostDto> postDtoList = postService.getAllPost();

        model.addAttribute("postlist", postDtoList);
        return "index";
    }
    @GetMapping("/about")
    public String about(){

        return "about";
    }
    @GetMapping("/post")
    public String post(){

        return "post";
    }
    @GetMapping("/contact")
    public String contact(){

        return "contact";
    }
    @GetMapping("/writepost")
    public String writepost(){

        return "writepost";
    }
    @PostMapping("/writepostaction")
    public String writepostaction(PostDto dto){
        postService.save(dto);
        return "redirect:/index";
    }

    @GetMapping("/viewpost/{postkey}")
    public String viewpost(@PathVariable("postkey") int postkey, Model model){
        PostDto postDto  = postService.getPost(postkey);
        model.addAttribute("post", postDto);
        return "viewpost";
    }

    @GetMapping("/updatepost/{postkey}")
    public String updatepost(@PathVariable("postkey") int postkey, Model model){
        PostDto postDto  = postService.getPost(postkey);
        model.addAttribute("post", postDto);

        return "updatepost";
    }
    @PostMapping("/updatepostcon/{postkey}")
    public String updatepostcon (@PathVariable("postkey") int postkey, PostDto postDto){
        postService.updatepost(postDto.getPostkey(), postDto);

        return "redirect:/index";
    }

    @RequestMapping("/deletepost/{postkey}")
    public String deletepost(@PathVariable("postkey") int postkey){
        postService.delPost(postkey);

        return "redirect:/index";

    }
}

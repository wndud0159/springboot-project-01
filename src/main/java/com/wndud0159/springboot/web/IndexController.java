package com.wndud0159.springboot.web;

import com.wndud0159.springboot.config.auth.LoginUser;
import com.wndud0159.springboot.config.auth.dto.SessionUser;
import com.wndud0159.springboot.service.PostsService;
import com.wndud0159.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("posts", postsService.findAllDesc());
//        return "index";
//    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto postsResponseDto = postsService.findById(id);
        model.addAttribute("posts", postsResponseDto);

        return "posts-update";
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser sessionUser) {
        model.addAttribute("posts", postsService.findAllDesc());

//        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");

        if(sessionUser != null) {
            model.addAttribute("userName", sessionUser.getName());
        }
        return "index";
    }
}

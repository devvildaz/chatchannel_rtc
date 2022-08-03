package org.devvildaz.chatchannel.api.v1;

import org.devvildaz.chatchannel.models.AppUser;
import org.devvildaz.chatchannel.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AppUserRepository _userService;

    @GetMapping
    private Flux<AppUser> getAllUser() {
        List<AppUser> users = _userService.findAll();
        return Flux.fromStream(users.stream());
    }
}

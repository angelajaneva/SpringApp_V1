
package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.User;
import mk.ukim.finki.wp.project_v1.model.dto.UserSigninDTO;
import mk.ukim.finki.wp.project_v1.service.impl.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")


public class UserApi {

    private final UserServiceImpl userService;

    public UserApi(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/signin")
    public String login(@RequestBody UserSigninDTO u) {
        return userService.signin(u.getUsername(), u.getPassword());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }
}




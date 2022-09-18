package comjava.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import comjava.entity.User;
import comjava.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserDetail(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}

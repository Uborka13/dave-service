package hu.ubi.soft.network.controllers;

import hu.ubi.soft.database.users.dto.Users;
import hu.ubi.soft.network.exceptions.UserAlreadyExistException;
import hu.ubi.soft.network.request.user.User;
import hu.ubi.soft.database.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping
    public @ResponseBody
    Users createUser(@ModelAttribute User request) {
        Users n;
        if (usersRepository.findByUserName(request.getName()) != null) {
            throw new UserAlreadyExistException(request.getName());
        } else {
            n = new Users(request.getName(), request.getEmail());
        }
        return usersRepository.save(n);
    }

    @GetMapping
    public @ResponseBody
    Iterable<Users> listAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{userId}")
    public @ResponseBody
    Users getUser(@PathVariable Long userId) {
        return usersRepository.findByUserId(userId);
    }
}

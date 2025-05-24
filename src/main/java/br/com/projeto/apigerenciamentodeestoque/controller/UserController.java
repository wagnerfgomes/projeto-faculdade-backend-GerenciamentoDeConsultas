package br.com.projeto.apigerenciamentodeestoque.controller;

import br.com.projeto.apigerenciamentodeestoque.DTOs.UserDto;
import br.com.projeto.apigerenciamentodeestoque.model.User.User;
import br.com.projeto.apigerenciamentodeestoque.repository.UserRoleRepository;
import br.com.projeto.apigerenciamentodeestoque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam(name = "username") String username){
        User user = userService.userByName(username);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        var users = userService.allUsers();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDto dto){
        User user = userService.updateUser(dto);
        return ResponseEntity.ok().body(user);
    }
}

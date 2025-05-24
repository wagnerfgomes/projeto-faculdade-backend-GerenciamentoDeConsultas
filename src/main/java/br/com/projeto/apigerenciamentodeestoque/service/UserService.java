package br.com.projeto.apigerenciamentodeestoque.service;

import br.com.projeto.apigerenciamentodeestoque.DTOs.UserDto;
import br.com.projeto.apigerenciamentodeestoque.exception.ApiException;
import br.com.projeto.apigerenciamentodeestoque.exception.ErrorDetails;
import br.com.projeto.apigerenciamentodeestoque.model.User.User;
import br.com.projeto.apigerenciamentodeestoque.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User userByName(String name){
        User user = userRepository.findUserByUsername(name);
        log.info(user.toString());
        if(user == null){
            throw new ApiException(ErrorDetails.USER_NOT_FOUND);
        }
        return user;
    }

    public List<User> allUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User updateUser(UserDto dto){
        User user = userRepository.findUserByUsername(dto.username());
        if(user == null){
            throw new ApiException(ErrorDetails.USER_NOT_FOUND);
        }
        if (dto.password() != null){
            if (user.getPassword() != dto.password()) {
                String encodePassword = new BCryptPasswordEncoder().encode(dto.password());
                user.setPassword(encodePassword);
            }else {
                throw new ApiException(ErrorDetails.PASSWORD_ALREADY_USED);
            }
        }
        user.setActive(dto.active());
        userRepository.save(user);
        return user;
    }

}

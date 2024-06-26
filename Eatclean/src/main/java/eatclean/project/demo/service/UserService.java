package eatclean.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatclean.project.demo.enity.Login;
import eatclean.project.demo.enity.User;
import eatclean.project.demo.enity.UserDto;
import eatclean.project.demo.repository.LoginRepository;
import eatclean.project.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    public void register(UserDto userDto) throws Exception {
        User existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            throw new Exception("Tài khoản email đã tồn tại!");
        }

        Login login = loginRepository.findByUsername(userDto.getUsername());
        if (login != null) {
            throw new Exception("Username đã tồn tại!");
        }

        Login newLogin = new Login();
        newLogin.setUsername(userDto.getUsername());
        newLogin.setPassword(userDto.getPassword());
        newLogin.setRole("customer");
        loginRepository.save(newLogin);

        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setLogin(newLogin);
        userRepository.save(newUser);
    }

    public User getUserByLoginId(int loginId) {
        return userRepository.findByLoginId(loginId);
    }

    public User getUserById(int id){
        return userRepository.findById(id).get();
    }

    
}

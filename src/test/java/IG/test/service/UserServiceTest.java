package IG.test.service;

import IG.test.entity.User;
import IG.test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
        this.userService = new UserService(userRepository);
    }

//    @Test
//    void loadUserByUsername_Should_Return_True() {
//        given(userRepository.findByUsername("Michel")).willReturn(
//                new User());
//
//        UserDetails user = userService.loadUserByUsername(new String("Michel"));
//        assertEquals(user,user);
//    }
}
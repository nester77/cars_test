package IG.test.service;

import IG.test.entity.User;
import IG.test.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameExceptionTest() {

        User user = new User();
        user.setUsername("John");

        Mockito.doReturn(null)
                .when(userRepository)
                .findByUsername("John");

        Assert.assertSame("User not found", userService.loadUserByUsername("John"));


    }
}
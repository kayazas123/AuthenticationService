package com.ayaz.assessment.service;


import com.ayaz.assessment.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsersServiceIntegrationTest {

    @Autowired
    private UserService service;

    @Test
    public void canSuccessfullySignup() {
        Optional<User> user = service.signup("dummyUsername", "dummypassword", "john", "doe");
        assertThat(user.get().getPassword(), not("dummypassword"));
        System.out.println("Encoded Password = " + user.get().getPassword());
    }

    @Test
    public void canSuccessfullySignin(){
        Optional<String> signin = service.signin("admin", "letmein");
        assertNotNull(signin);
        assertTrue(signin.isPresent());

    }

    @Test
    public void canSuccessfullyGetAllUsers(){
        List<User> all = service.getAll();
        assertNotNull(all);
    }
}

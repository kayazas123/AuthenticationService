package com.ayaz.assessment.domain;

import org.junit.Test;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserConstructorGettersAndSetters(){
        User user = new User();
        User user1 = new User("test","test",null,"testFirstName","testLastName");
        assertNotNull(user1.getUsername());
        assertNotNull(user1.getPassword());
        assertNotNull(user1.getFirstName());
        assertNotNull(user1.getLastName());

        user1.setRoles(null);
        assertNull(user1.getRoles());

        user1.setId(1L);
        assertNotNull(user1.getId());

        user1.setFirstName("test1");
        user1.setPassword("test1");
        user1.setUsername("username");
        user1.setLastName("lastname");

        assertNotNull(user1.getUsername());
        assertNotNull(user1.getPassword());
        assertNotNull(user1.getFirstName());
        assertNotNull(user1.getLastName());
    }



}

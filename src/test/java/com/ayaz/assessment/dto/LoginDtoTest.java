package com.ayaz.assessment.dto;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginDtoTest {

    @Test
    public void testLoginDtoConstructorAndGetters() {
        LoginDto loginDto = new LoginDto("test","test","firstname","lastname");
        assertThat(loginDto.getUsername(), is("test"));
        assertThat(loginDto.getPassword(), is("test"));
        assertThat(loginDto.getFirstName(), is("firstname"));
        assertThat(loginDto.getLastName(), is("lastname"));

        loginDto.setPassword("test123");
        assertThat(loginDto.getPassword(), is("test123"));

        loginDto.setUsername("test123");
        assertThat(loginDto.getUsername(),is("test123"));


        LoginDto loginDto1  = new LoginDto();

    }
}

package com.ayaz.assessment.security

import io.jsonwebtoken.ExpiredJwtException
import org.junit.Test
import org.junit.internal.runners.statements.ExpectException
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import javax.validation.constraints.AssertTrue

import static org.junit.Assert.assertNotNull

@RunWith(SpringRunner.class)
@SpringBootTest
class JwtProviderTestCase {

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE1NTIyMTIyNjAsImV4cCI6MTU1MjIxMjg2MH0.knSEG3kSD7Dfjbo8LW-bc0py2oCaV-6fCzLyjyheQtc";

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    public void verfiyToken() {
        jwtProvider.isValidToken(TOKEN);

    }

    @Test(expected = ExpiredJwtException.class)
    public void getUsernameFromToken(){
        jwtProvider.getUsername(TOKEN);
    }

}

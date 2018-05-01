package com.quizgame.spring.service;

import com.quizgame.spring.StubApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StubApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest extends ServiceTestBase {

    @Test
    public void testCanCreateUser() {

        String userId = "a";
        String userPassword = "123";

        boolean isCreated = createUser(userId, userPassword);
        assertTrue(isCreated);
    }

    @Test
    public void testCanCreateUserWithInvalidRegEx() {

        String userId = "a@";
        String userPassword = "123";

        try{
            createUser(userId, userPassword);
        } catch (Exception e) {
            // expected
        }
    }

    @Test
    public void testCanCreateWithWhiteSpaces() {

        String userId = "     ";
        String userPassword = "123";

        try {
            createUser(userId, userPassword);
        } catch (Exception e) {
            // expected
        }
    }

    @Test
    public void testCreateTwoUserWithSameId() {

        String userOne = "a";
        String userOnePassword = "123";

        boolean isUserOneCreated = createUser(userOne, userOnePassword);
        assertTrue(isUserOneCreated);

        String userTwo = "a";
        String userTwoPassword = "123";

        boolean isUserTwoCreated = createUser(userTwo, userTwoPassword);
        assertFalse(isUserTwoCreated);

    }
}
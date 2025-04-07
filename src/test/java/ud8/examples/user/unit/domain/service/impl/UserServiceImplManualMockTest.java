package ud8.examples.user.unit.domain.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud8.examples.user.common.exception.ResourceNotFoundException;
import ud8.examples.user.domain.entity.User;
import ud8.examples.user.domain.service.UserService;
import ud8.examples.user.domain.service.impl.UserServiceImpl;
import ud8.examples.user.mock.domain.service.EmailServiceMock;
import ud8.examples.user.mock.persistance.repository.UserRepositoryMock;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplManualMockTest {
    private static final User USER = new User(1, "Test", "test@fpmislata.com");
    private static UserService userService;

    @BeforeAll
    static void setup(){
        userService = new UserServiceImpl(
                new EmailServiceMock(),
                new UserRepositoryMock(USER)
        );
    }

    @Nested
    class FindByIdTests {
        @Test
        void givenExistingId_shouldReturnUser() throws ResourceNotFoundException {
            // Act
            User actual = userService.findById(USER.getId());

            // Assert
            assertSame(USER, actual);
        }

        @Test
        void givenInexistentId_shouldThrowResourceNotFoundException(){
            // Assert
            assertThrows(ResourceNotFoundException.class, () -> userService.findById(-1));
        }
    }

    @Nested
    class CreateTests {
        @Test
        void givenExistingUser_shouldReturnFalse(){
            boolean result = userService.create(USER);

            assertFalse(result);
        }

        @Test
        void givenNonExistingUser_shouldReturnTrue(){
            User newUser = new User(2, "NewUser", "newuser@fpmislata.com");
            boolean result = userService.create(newUser);

            assertTrue(result);
        }
    }

    @Nested
    class LoginTests {
        @Test
        void givenInexistingUser_shouldReturnFalse(){
            String email = "inexistent@fpmislata.com";
            boolean result = userService.login(email, "1234");

            assertFalse(result);
        }

        @Test
        void givenExistingUserAndCorrectPassword_shouldReturnTrue(){
            String email = USER.getEmail();
            boolean result = userService.login(email, "1234");

            assertTrue(result);
        }

        @Test
        void givenExistingUserAndIncorrectPassword_shouldReturnFalse(){
            String email = USER.getEmail();
            boolean result = userService.login(email, "incorrect");

            assertFalse(result);
        }
    }
}
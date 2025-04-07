package ud8.examples.user.unit.domain.service.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ud8.examples.user.common.exception.ResourceNotFoundException;
import ud8.examples.user.domain.entity.User;
import ud8.examples.user.domain.service.EmailService;
import ud8.examples.user.domain.service.impl.UserServiceImpl;
import ud8.examples.user.persistance.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplMockitoTest {
    private static final User USER = new User(1, "Test", "test@fpmislata.com");

    @Mock
    private EmailService emailService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Nested
    class FindByIdTests {
        @Test
        void givenExistingId_shouldReturnUser() throws ResourceNotFoundException {
            // Arrange
            int id = USER.getId();
            when(userRepository.findById(id)).thenReturn(USER);

            // Act
            User actual = userService.findById(id);

            // Assert
            assertEquals(USER, actual);
        }

        @Test
        void givenInexistentId_shouldThrowResourceNotFoundException(){
            // Arrange
            int id = 2;
            when(userRepository.findById(id)).thenReturn(null);

            // Act & Assert
            assertThrows(ResourceNotFoundException.class, () -> userService.findById(id));
        }
    }

    @Nested
    class CreateTests {
        @Test
        void givenExistingUser_shouldNotCreateUser(){
            // Arrange
            String email = USER.getEmail();
            when(userRepository.existsByEmail(email)).thenReturn(true);

            // Act
            boolean result = userService.create(USER);

            // Assert
            assertAll(
                () -> assertFalse(result),
                () -> verify(userRepository, never()).save(USER),
                () -> verify(emailService, never()).sendConfirmationEmail(email)
            );
        }

        @Test
        void givenInexistingUser_shouldCreateUser(){
            // Arrange
            String email = "newuser@localhost";
            User user = new User(2, "New User", email);
            when(userRepository.existsByEmail(email)).thenReturn(false);
            doNothing().when(emailService).sendConfirmationEmail(email);

            // Act
            boolean result = userService.create(user);

            // Assert
            assertAll(
                () -> assertTrue(result),
                () -> verify(userRepository).save(user),
                () -> verify(emailService).sendConfirmationEmail(email)
            );
        }
    }

    @Nested
    class UpdateTests {
        @Test
        void givenExistingUser_shouldUpdateUser(){
            // Arrange
            int id = USER.getId();
            when(userRepository.existsById(id)).thenReturn(true);

            // Act
            boolean result = userService.update(USER);

            // Assert
            assertAll(
                () -> assertTrue(result),
                () -> verify(userRepository).save(USER)
            );
        }

        @Test
        void givenNonExistingUser_shouldNotUpdateUser(){
            // Arrange
            int id = USER.getId();
            when(userRepository.existsById(id)).thenReturn(false);

            // Act
            boolean result = userService.update(USER);

            // Assert
            assertAll(
                    () -> assertFalse(result),
                    () -> verify(userRepository, never()).save(USER)
            );
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void givenExistingUser_shouldDeleteUser(){
            // Arrange
            int id = 1;
            when(userRepository.existsById(id)).thenReturn(true);

            // Act
            boolean result = userService.delete(id);

            // Assert
            assertTrue(result);
            verify(userRepository).delete(id);
        }

        @Test
        void givenNonExistingUser_shouldNotDeleteUser(){
            // Arrange
            int id = 2;
            when(userRepository.existsById(id)).thenReturn(false);

            // Act
            boolean result = userService.delete(id);

            // Assert
            assertFalse(result);
            verify(userRepository, never()).delete(id);
        }
    }

    @Nested
    class LoginTests {
       @Test
       void givenNonExistingUser_shouldNotLogin(){
           // Arrange
           String email = "inexistent@localhost";
           String password = "password";
           when(userRepository.existsByEmail(email)).thenReturn(false);

           // Act
           boolean result = userService.login(email, password);

           // Assert
           assertFalse(result);
       }

        @Test
        void givenExistingUserAndIncorrectPassword_shouldNotLogin(){
            // Arrange
            String email = "existing@localhost";
            String password = "incorrect";
            when(userRepository.existsByEmail(email)).thenReturn(true);
            when(userRepository.getPasswordByEmail(email)).thenReturn("correct");

            // Act
            boolean result = userService.login(email, password);

            // Assert
            assertFalse(result);
        }

        @Test
        void givenExistingUserAndCorrectPassword_shouldLogin(){
            // Arrange
            String email = "existing@localhost";
            String password = "correct";
            when(userRepository.existsByEmail(email)).thenReturn(true);
            when(userRepository.getPasswordByEmail(email)).thenReturn("correct");

            // Act
            boolean result = userService.login(email, password);

            // Assert
            assertTrue(result);
        }
    }
}
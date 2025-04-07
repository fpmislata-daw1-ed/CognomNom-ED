package ud8.examples.user.domain.service.impl;

import ud8.examples.user.common.exception.ResourceNotFoundException;
import ud8.examples.user.domain.entity.User;
import ud8.examples.user.domain.service.EmailService;
import ud8.examples.user.domain.service.UserService;
import ud8.examples.user.persistance.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final EmailService emailService;
    private final UserRepository userRepository;

    public UserServiceImpl(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) throws ResourceNotFoundException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public boolean create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        }
        userRepository.save(user);
        emailService.sendConfirmationEmail(user.getEmail());
        return true;
    }

    @Override
    public boolean update(User user) {
        if (!userRepository.existsById(user.getId())) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean delete(int id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.delete(id);
        return true;
    }

    @Override
    public boolean login(String email, String password) {
        if(!userRepository.existsByEmail(email)){
            return false;
        }
        String actualPassword = userRepository.getPasswordByEmail(email);
        return password.equals(actualPassword);
    }

    /*
    @Override
    public boolean resetPassword(String email) {
        if(!userRepository.existsByEmail(email))
            return false;

        emailService.sendResetPasswordEmail(email);
        return false;
    }

    public boolean changePassword(String email, String password, String passwordConfirmation) {
        if(!userRepository.existsByEmail(email))
            return false;

        if(!password.equals(passwordConfirmation))
            return false;

        User user = userRepository.findByEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return true;
    }
    */
}

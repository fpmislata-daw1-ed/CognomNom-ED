package ud8.examples.user.domain.service;

import ud8.examples.user.domain.entity.User;
import ud8.examples.user.common.exception.ResourceNotFoundException;

public interface UserService {
    User findById(int id) throws ResourceNotFoundException;
    boolean create(User user);
    boolean update(User user);
    boolean delete(int id);
    boolean login(String email, String password);
    // boolean resetPassword(String email);
}

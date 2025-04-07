package ud8.examples.user.persistance.repository;

import ud8.examples.user.domain.entity.User;

public interface UserRepository {
    User findById(int userId);
    boolean existsByEmail(String email);
    boolean existsById(int userId);
    void save(User user);
    void delete(int userId);
    String getPasswordByEmail(String email);
}

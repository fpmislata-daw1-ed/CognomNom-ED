package ud8.examples.user.mock.persistance.repository;

import ud8.examples.user.domain.entity.User;
import ud8.examples.user.persistance.repository.UserRepository;

public class UserRepositoryMock implements UserRepository {
    private final User user;

    public UserRepositoryMock(User user) {
        this.user = user;
    }

    @Override
    public User findById(int userId) {
        if (userId == this.user.getId())
            return this.user;
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return email.equals(user.getEmail());
    }

    @Override
    public boolean existsById(int userId) {
        return false;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(int userId) {

    }

    @Override
    public String getPasswordByEmail(String email) {
        return "1234";
    }
}

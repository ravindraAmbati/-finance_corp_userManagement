package corp.finance.UserManagement.repository;

import corp.finance.UserManagement.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    List<User> getUsers(List<String> userIds);

    User getUser(String userId);
}

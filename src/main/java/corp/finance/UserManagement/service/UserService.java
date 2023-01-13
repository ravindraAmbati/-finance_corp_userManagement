package corp.finance.UserManagement.service;

import corp.finance.UserManagement.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> getUsers(List<String> userIds);

    User getUser(String userId);
}

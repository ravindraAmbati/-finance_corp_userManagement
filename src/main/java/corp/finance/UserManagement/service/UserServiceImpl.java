package corp.finance.UserManagement.service;

import corp.finance.UserManagement.model.User;
import corp.finance.UserManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("getAllUsers()");
        return userRepository.getUsers();
    }

    @Override
    public List<User> getUsers(List<String> userIds) {
        log.info("getUsers() userIds: {}", userIds);
        if (null != userIds && !userIds.isEmpty()) {
            return userRepository.getUsers(userIds);
        }
        log.info("EMPTY results INVALID userIds: {}", userIds);
        return Collections.emptyList();

    }

    @Override
    public User getUser(String userId) {
        log.info("getUser() userId: {}", userId);
        if (null != userId && !userId.isEmpty() && !userId.isBlank()) {
            return userRepository.getUser(userId);
        }
        log.info("EMPTY results INVALID userId: {}", userId);
        return User.builder().build();
    }
}

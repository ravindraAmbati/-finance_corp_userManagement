package corp.finance.UserManagement.repository;

import corp.finance.UserManagement.model.Audit;
import corp.finance.UserManagement.model.Contact;
import corp.finance.UserManagement.model.User;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    private User user;

    @PostConstruct
    void init() {
        log.info("init()");
        Audit audit = Audit
                .builder()
                .createdBy("opr001")
                .createdOn(LocalDateTime.of(2022, Month.APRIL, 1, 9, 57))
                .updatedBy("opr002")
                .updatedOn(LocalDateTime.now())
                .build();
        Contact contact = Contact
                .builder()
                .address("Hyderabad")
                .phoneNumber("0123456789")
                .emailAddress("ravindra@fin.corp")
                .audit(audit)
                .build();
        user = User
                .builder()
                .userId("usr001")
                .userName("Ravindra")
                .userType("Gold")
                .productIds(List.of("prd001"))
                .collateralIds(List.of("clt001"))
                .contact(contact)
                .audit(audit)
                .build();
    }

    @Override
    public List<User> getAllUsers() {
        log.info("getAllUsers()");
        return List.of(user);
    }

    @Override
    public List<User> getUsers(List<String> userIds) {
        log.info("getAllUsers() userIds: {}", userIds);
        return getAllUsers()
                .stream()
                .filter(user -> userIds.contains(user.getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public User getUser(String userId) {
        log.info("getUser() userId: {}", userId);
        return getAllUsers()
                .stream()
                .filter(user -> userId.equals(user.getUserId()))
                .findFirst()
                .orElse(User
                        .builder()
                        .contact(Contact.builder().build())
                        .audit(Audit.builder().build())
                        .build());
    }

}

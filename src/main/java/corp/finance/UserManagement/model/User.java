package corp.finance.UserManagement.model;


import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class User implements Serializable {

    private String userId;
    private String userName;
    private String userType;
    private List<String> productIds;
    private List<String> collateralIds;
    private Contact contact;
    private Audit audit;
}

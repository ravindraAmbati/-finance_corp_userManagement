package corp.finance.UserManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Properties {

    private String message;
    private String buildVersion;
    private Map<String, String> mailDetails;
}

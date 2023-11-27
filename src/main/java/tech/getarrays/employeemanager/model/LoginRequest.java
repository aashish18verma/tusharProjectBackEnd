package tech.getarrays.employeemanager.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class LoginRequest {
    private String username;
    private String password;

}

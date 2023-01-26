package ua.com.foxminded.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegistrationDto {
    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}

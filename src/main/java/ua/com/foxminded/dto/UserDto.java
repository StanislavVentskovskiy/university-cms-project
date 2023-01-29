package ua.com.foxminded.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    @NotEmpty
    private String username;
    private Integer newRoleId;
}

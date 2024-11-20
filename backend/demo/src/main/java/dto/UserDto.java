package dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Level is mandatory")
    private String level; 

    public UserDto() {}

    public UserDto(String username, String level) {
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {  // Este método deve existir
        return level;
    }

    public void setLevel(String level) {  // Este método também deve existir
        this.level = level;
    }
}

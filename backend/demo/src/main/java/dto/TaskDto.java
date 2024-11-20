package dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TaskDto {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    @NotNull(message = "Due date is mandatory")
    private Date dueDate;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    public TaskDto() {
    }

    public TaskDto(String title, String description, Date dueDate, String status, Long userId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.userId = userId;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

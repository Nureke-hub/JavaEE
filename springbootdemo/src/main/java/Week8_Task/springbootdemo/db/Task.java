package Week8_Task.springbootdemo.db;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String description;
    private String deadlineDate; // java.sql.Date or String
    private boolean isCompleted;
}

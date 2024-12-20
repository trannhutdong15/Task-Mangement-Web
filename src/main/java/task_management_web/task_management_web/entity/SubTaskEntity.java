package task_management_web.task_management_web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "SubTasks")
@Getter
@Setter
public class SubTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", referencedColumnName = "id", nullable = false)
    private TaskEntity task;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity assignedUser;

    @Column(name = "status", length = 50, nullable = false)
    private String status = "Pending"; // Default status is "Pending"

    @Column(name = "progress_percentage", nullable = false)
    private int progressPercentage = 0; // Default progress is 0

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

}

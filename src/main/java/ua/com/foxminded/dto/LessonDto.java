package ua.com.foxminded.dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class LessonDto {

    @Id
    private Integer id;

    private int roomId;
    private int groupId;
    private int teacherId;
    private int subjectId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}

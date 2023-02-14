package ua.com.foxminded.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="lessons",schema = "university")
public class Lesson {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @OneToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private Group group;

    @OneToOne
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private Subject subject;


    public Lesson(int roomId, int groupId, int teacherId, int subjectId, LocalTime startTime, LocalTime endTime, LocalDate date) {
        this.roomId = roomId;
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    public Lesson(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lesson))
            return false;
        Lesson other = (Lesson) o;
        boolean valueEquals = (this.startTime == null && other.startTime == null)
                || (this.startTime != null && this.startTime.equals(other.startTime));
        boolean storeEquals = (this.date == null && other.date == null)
                || (this.date != null && this.date.equals(other.date));
        return valueEquals && storeEquals;
    }

    @Override
    public final int hashCode(){
        int hashCode = 17;
        if(startTime != null) {
            hashCode = 31 * hashCode + startTime.hashCode();
        }
        if (date != null) {
            hashCode = 31 * hashCode * date.hashCode();
        }
        return hashCode;
    }
}

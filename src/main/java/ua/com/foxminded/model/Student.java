package ua.com.foxminded.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students", schema = "university")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "course")
    private int course;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    public Student(int id, int groupId, int course, String name, String email, LocalDate birthsday) {
        this.id = id;
        this.groupId = groupId;
        this.course = course;
        this.name = name;
        this.email = email;
        this.birthday = birthsday;
    }

    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthsday() {
        return birthday;
    }

    public void setBirthsday(LocalDate birthsday) {
        this.birthday = birthsday;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student))
            return false;
        Student other = (Student) o;
        boolean valueEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
        boolean storeEquals = (this.birthday == null && other.birthday == null)
                || (this.birthday != null && this.birthday.equals(other.birthday));
        return valueEquals && storeEquals;
    }

    @Override
    public final int hashCode(){
        int hashCode = 17;
        if(name != null) {
            hashCode = 31 * hashCode + name.hashCode();
        }
        if (birthday != null) {
            hashCode = 31 * hashCode * birthday.hashCode();
        }
        return hashCode;
    }
}

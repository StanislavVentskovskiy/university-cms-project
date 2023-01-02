package ua.com.foxminded.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teachers", schema = "university")
@SecondaryTable(name="subjects", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Teacher {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "subject_id", insertable = false, updatable = false)
    private int subjectId;

    @Column(name = "position")
    private String position;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Teacher(int id, String name, String email, LocalDate birthday, int subjectId, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.subjectId = subjectId;
        this.position = position;
    }

    public Teacher(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        if (!(o instanceof Teacher))
            return false;
        Teacher other = (Teacher) o;
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

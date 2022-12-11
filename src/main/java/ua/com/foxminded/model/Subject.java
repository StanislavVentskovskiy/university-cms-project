package ua.com.foxminded.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects", schema = "university")
public class Subject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Subject(String name){
        this.name = name;
    }

    public Subject(){}

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Subject))
            return false;
        Subject other = (Subject) o;
        boolean valueEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));

        return valueEquals;
    }

    @Override
    public final int hashCode(){
        int hashCode = 17;
        if(name != null) {
            hashCode = 31 * hashCode + name.hashCode();
        }

        return hashCode;
    }
}

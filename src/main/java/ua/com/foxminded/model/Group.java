package ua.com.foxminded.model;

import jakarta.persistence.*;

@Entity
@Table(name="groups", schema="university")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
            name="name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public Group(String name){
        this.name = name;
    }

    public Group(){}

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
        if (!(o instanceof Group))
            return false;
        Group other = (Group) o;
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

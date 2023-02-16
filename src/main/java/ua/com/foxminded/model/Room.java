package ua.com.foxminded.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms", schema = "university")
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "floor")
    private int floor;

    @Column(name = "number")
    private int number;

    public Room(int floor, int number){
        this.floor = floor;
        this.number = number;
    }

    public Room(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room))
            return false;
        Room other = (Room) o;
        boolean valueEquals = (Integer.valueOf(this.floor) == null && Integer.valueOf(other.floor) == null)
                || (this.number == other.number);

        return valueEquals;
    }

    @Override
    public final int hashCode(){
        int hashCode = 17;
        hashCode = 31 * hashCode + Integer.valueOf(floor).hashCode();

        return hashCode;
    }
}

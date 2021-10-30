package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory  extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    public int id;


@Size(min=3, message="Name must be at least 3 characters long")
    public String name;

@OneToMany(mappedBy = "eventCategory")
private  final List<Event> events=new ArrayList<>();

    public EventCategory() {
    }

    public EventCategory( String name) {

        this.name = name;
    }

//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EventCategory that = (EventCategory) o;
//        return id == that.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}

package org.launchcode.codingevents.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    private int id;

    @NotBlank
@Size(min=3,max=30  ,message="Name must be  between 3-30 character" )
    private String name;

    @Size(max=500 ,message="Description is too long")
    private  String description;

    private static int nextId=1;

    @NotBlank(message="name is required")
    @Email(message="Invalid Try again")
    private String contactEmail;

    public Event(String name,String description,String contactEmail) {
        this.name = name;
        this.description=description;
        this.contactEmail=contactEmail;
        this.id=nextId;

        nextId++;
    }
    public Event() {}

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package org.home.model.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    private double value;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    public Record(){
    }

    public Record(String description, double value, Calendar date, User user) {
        setDescription(description);
        setValue(value);
        setDate(date);
        setUser(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return getId() == record.getId() &&
                Double.compare(record.getValue(), getValue()) == 0 &&
                Objects.equals(getDescription(), record.getDescription()) &&
                Objects.equals(getDate(), record.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getValue(), getDate());
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}

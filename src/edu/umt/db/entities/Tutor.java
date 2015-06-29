package edu.umt.db.entities;

import edu.umt.db.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by tb189431e on 6/8/15.
 */
@Entity
@Table(name="TUTOR")
public class Tutor extends BaseEntity{
    private int tutorId;
    private String lastName;
    private String firstName;
    private Set<Session> sessions;



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "TUTOR_ID", nullable = false, insertable = false, updatable = false)
    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @OneToMany(mappedBy = "tutor", fetch = FetchType.EAGER)
    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tutor tutor = (Tutor) o;

        if (tutorId != tutor.tutorId) return false;
        if (firstName != null ? !firstName.equals(tutor.firstName) : tutor.firstName != null) return false;
        if (lastName != null ? !lastName.equals(tutor.lastName) : tutor.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tutorId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}

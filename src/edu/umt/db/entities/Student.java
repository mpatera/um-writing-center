package edu.umt.db.entities;

import edu.umt.db.BaseEntity;
import edu.umt.utils.MaskStripper;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by tb189431e on 6/8/15.
 */
@Entity
public class Student extends BaseEntity{
    private int studentId;
    private String lastName;
    private String firstName;
    private BigInteger phone;
    private Set<Session> sessions;
    @Transient
    private String phoneAsString;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID", nullable = false, insertable = true, updatable = true)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    @Basic
    @Column(name = "PHONE", nullable = true, insertable = true, updatable = true)
    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    @OneToMany(mappedBy="student", fetch=FetchType.LAZY)
    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    @Transient
    public String getPhoneAsString() {
        return phone.toString();
    }

    @Transient
    public void setPhoneAsString(String phoneAsString) {
        this.phoneAsString = phoneAsString;
        this.phone = MaskStripper.stripPhoneNumberMask(phoneAsString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}

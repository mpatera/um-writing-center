package edu.umt.db.entities;

import edu.umt.db.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Set;

/**
 * Created by tb189431e on 6/8/15.
 */
@Entity
@Table(name="SESSION")
public class Session extends BaseEntity{
    private int sessionId;
    private Tutor tutor;
    private Student student;
    private String topic;
    private Timestamp created;
    private Timestamp modified;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SESSION_ID", nullable=false, insertable = true, updatable = true)
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TUTOR_ID", nullable=false)
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_ID", nullable=false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Basic
    @Column(name = "TOPIC", nullable = true, insertable = true, updatable = true, length = 400)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "CREATED", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "MODIFIED", nullable = true, insertable = true, updatable = true)
    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Transient
    public String getSessionDateAsString(){
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT);
        return df.format(created);
    }


    /** Base Entity Methods **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (sessionId != session.sessionId) return false;
        if (created != null ? !created.equals(session.created) : session.created != null) return false;
        if (modified != null ? !modified.equals(session.modified) : session.modified != null) return false;
        if (topic != null ? !topic.equals(session.topic) : session.topic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        return result;
    }
}

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
    private Timestamp created;
    private Timestamp modified;
    private Source source;
    private TopicsCovered topicsCovered;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable=false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    @OneToOne (fetch = FetchType.LAZY, mappedBy = "session", cascade = CascadeType.ALL)
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "session", cascade = CascadeType.ALL)
    public TopicsCovered getTopicsCovered(){
        return topicsCovered;
    }

    public void setTopicsCovered(TopicsCovered topicsCovered){
        this.topicsCovered = topicsCovered;
    }
}

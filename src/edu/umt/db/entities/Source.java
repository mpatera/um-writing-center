package edu.umt.db.entities;

import javax.persistence.*;

/**
 * Created by tb189431e on 7/16/15.
 */
@Entity
public class Source {
    private int sessionId;
    private int inClass;
    private int faculty;
    private int students;
    private int website;
    private String other;
    private Session session;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SESSION_ID", nullable = false, insertable = true, updatable = true)
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sourceId) {
        this.sessionId = sourceId;
    }

    @Basic
    @Column(name = "IN_CLASS", nullable = false, insertable = true, updatable = true)
    public int getInClass() {
        return inClass;
    }

    public void setInClass(int inClass) {
        this.inClass = inClass;
    }

    @Basic
    @Column(name = "FACULTY", nullable = false, insertable = true, updatable = true)
    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    @Basic
    @Column(name = "STUDENTS", nullable = false, insertable = true, updatable = true)
    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Basic
    @Column(name = "WEBSITE", nullable = false, insertable = true, updatable = true)
    public int getWebsite() {
        return website;
    }

    public void setWebsite(int website) {
        this.website = website;
    }

    @Basic
    @Column(name = "OTHER", nullable = true, insertable = true, updatable = true, length = 45)
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }


    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Source source = (Source) o;

        if (faculty != source.faculty) return false;
        if (inClass != source.inClass) return false;
        if (sessionId != source.sessionId) return false;
        if (students != source.students) return false;
        if (website != source.website) return false;
        if (other != null ? !other.equals(source.other) : source.other != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + inClass;
        result = 31 * result + faculty;
        result = 31 * result + students;
        result = 31 * result + website;
        result = 31 * result + (other != null ? other.hashCode() : 0);
        return result;
    }
}

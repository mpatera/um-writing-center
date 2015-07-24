package edu.umt.db.entities;

import javax.persistence.*;

/**
 * Created by tb189431e on 7/16/15.
 */
@Entity
@Table(name = "TOPICS_COVERED", schema = "", catalog = "test")
public class TopicsCovered {
    private int sessionId;
    private int responsiveness;
    private int thesis;
    private int clarity;
    private int punctuation;
    private int reading;
    private int ideaDev;
    private int support;
    private int formatCitation;
    private int usage;
    private int organization;
    private int coherence;
    private int grammarSpelling;
    private int syntax;
    private String other;
    private Session session;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SESSION_ID", nullable = false, insertable = true, updatable = true)
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int topicId) {
        this.sessionId = topicId;
    }

    @Basic
    @Column(name = "RESPONSIVENESS", nullable = false, insertable = true, updatable = true)
    public int getResponsiveness() {
        return responsiveness;
    }

    public void setResponsiveness(int responsiveness) {
        this.responsiveness = responsiveness;
    }

    @Basic
    @Column(name = "THESIS", nullable = false, insertable = true, updatable = true)
    public int getThesis() {
        return thesis;
    }

    public void setThesis(int thesis) {
        this.thesis = thesis;
    }

    @Basic
    @Column(name = "CLARITY", nullable = false, insertable = true, updatable = true)
    public int getClarity() {
        return clarity;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    @Basic
    @Column(name = "PUNCTUATION", nullable = false, insertable = true, updatable = true)
    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    @Basic
    @Column(name = "READING", nullable = false, insertable = true, updatable = true)
    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    @Basic
    @Column(name = "IDEA_DEV", nullable = false, insertable = true, updatable = true)
    public int getIdeaDev() {
        return ideaDev;
    }

    public void setIdeaDev(int ideaDev) {
        this.ideaDev = ideaDev;
    }

    @Basic
    @Column(name = "SUPPORT", nullable = false, insertable = true, updatable = true)
    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    @Basic
    @Column(name = "FORMAT_CITATION", nullable = false, insertable = true, updatable = true)
    public int getFormatCitation() {
        return formatCitation;
    }

    public void setFormatCitation(int formatCitation) {
        this.formatCitation = formatCitation;
    }

    @Basic
    @Column(name = "USAGE", nullable = false, insertable = true, updatable = true)
    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    @Basic
    @Column(name = "ORGANIZATION", nullable = false, insertable = true, updatable = true)
    public int getOrganization() {
        return organization;
    }

    public void setOrganization(int organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "COHERENCE", nullable = false, insertable = true, updatable = true)
    public int getCoherence() {
        return coherence;
    }

    public void setCoherence(int coherence) {
        this.coherence = coherence;
    }

    @Basic
    @Column(name = "GRAMMAR_SPELLING", nullable = false, insertable = true, updatable = true)
    public int getGrammarSpelling() {
        return grammarSpelling;
    }

    public void setGrammarSpelling(int grammarSpelling) {
        this.grammarSpelling = grammarSpelling;
    }

    @Basic
    @Column(name = "SYNTAX", nullable = false, insertable = true, updatable = true)
    public int getSyntax() {
        return syntax;
    }

    public void setSyntax(int syntax) {
        this.syntax = syntax;
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

        TopicsCovered that = (TopicsCovered) o;

        if (clarity != that.clarity) return false;
        if (coherence != that.coherence) return false;
        if (formatCitation != that.formatCitation) return false;
        if (grammarSpelling != that.grammarSpelling) return false;
        if (ideaDev != that.ideaDev) return false;
        if (organization != that.organization) return false;
        if (punctuation != that.punctuation) return false;
        if (reading != that.reading) return false;
        if (responsiveness != that.responsiveness) return false;
        if (support != that.support) return false;
        if (syntax != that.syntax) return false;
        if (thesis != that.thesis) return false;
        if (sessionId != that.sessionId) return false;
        if (usage != that.usage) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + responsiveness;
        result = 31 * result + thesis;
        result = 31 * result + clarity;
        result = 31 * result + punctuation;
        result = 31 * result + reading;
        result = 31 * result + ideaDev;
        result = 31 * result + support;
        result = 31 * result + formatCitation;
        result = 31 * result + usage;
        result = 31 * result + organization;
        result = 31 * result + coherence;
        result = 31 * result + grammarSpelling;
        result = 31 * result + syntax;
        result = 31 * result + (other != null ? other.hashCode() : 0);
        return result;
    }
}

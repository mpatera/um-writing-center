package edu.umt.db.entities;

import edu.umt.db.BaseEntity;

import javax.persistence.*;

/**
 * Created by tb189431e on 7/30/15.
 */
@Entity
@Table(name = "SOURCE_NAMES")
public class SourceNames extends BaseEntity{

    private int sourceNameId;
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "SOURCENAME_ID", nullable = false, insertable = true, updatable = true)
    public int getSourceNameId() {
        return sourceNameId;
    }

    public void setSourceNameId(int sourceNameId) {
        this.sourceNameId = sourceNameId;
    }


    @Basic
    @Column(name = "NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

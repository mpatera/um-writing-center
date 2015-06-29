package edu.umt.jsf.beans;

import edu.umt.db.entities.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tb189431e on 6/29/15.
 */
public class SessionBackingBean implements Serializable {
    private Logger log = LoggerFactory.getLogger(SessionBackingBean.class);
    private List<Session> sessions;


}

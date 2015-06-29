package edu.umt.tests;

import edu.umt.db.HibernateUtils;
import org.hibernate.Session;

public class HibernateUtilsTest {

    @org.junit.Before
    public void setUp() throws Exception {
        //
    }

    @org.junit.Test
    public void testGetSessionFactory() throws Exception {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        org.junit.Assert.assertTrue(hibernateSession != null);
    }
}
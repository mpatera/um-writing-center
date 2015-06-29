package edu.umt.tests;

import edu.umt.db.BaseEntity;
import edu.umt.db.DatabaseManager;
import edu.umt.db.entities.Session;
import edu.umt.db.entities.Student;
import edu.umt.db.entities.Tutor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseManagerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetRecord() throws Exception {
        BaseEntity tutor = DatabaseManager.getRecord(new Tutor(), new Integer(1));
        Assert.assertTrue(tutor instanceof Tutor);
    }

    @Test
    public void testSaveRecord() throws Exception {
        BaseEntity tutor = MockFactory.getMock(Types.TUTOR);

        try{
            DatabaseManager.saveRecord(tutor);
            System.out.println("Success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRecords() throws Exception {
        List<Tutor> tutorList = DatabaseManager.getRecords(Tutor.class);
        List<Student> studentList = DatabaseManager.getRecords(Student.class);
        List<Session> sessionList = DatabaseManager.getRecords(Session.class);
        Assert.assertTrue(tutorList.size() > 0 && studentList.size() > 0 && sessionList.size() > 0);
    }

    @Test
    public void testDeleteRecord() throws Exception {

    }
}
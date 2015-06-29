package edu.umt.tests;

import edu.umt.db.BaseEntity;
import edu.umt.db.entities.Student;
import edu.umt.db.entities.Tutor;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;

/**
 * Created by tb189431e on 6/26/15.
 */
public class MockFactory {

    public static BaseEntity getMock(Types mockType) {
        BaseEntity be = null;
        switch (mockType) {
            case TUTOR:
                Tutor tutor = new Tutor();
                tutor.setFirstName(RandomStringUtils.randomAlphabetic(5));
                tutor.setLastName(RandomStringUtils.randomAlphabetic(7));
                be = tutor;
                break;
            case STUDENT:
                Student student = new Student();
                student.setFirstName(RandomStringUtils.randomAlphabetic(5));
                student.setLastName(RandomStringUtils.randomAlphabetic(7));
                student.setPhone(new BigInteger("1234567890"));
                be = student;
                break;
        }
        return be;
    }
}

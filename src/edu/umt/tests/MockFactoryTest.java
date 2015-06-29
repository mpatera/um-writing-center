package edu.umt.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class MockFactoryTest {

    @Test
    public void testGetMock() throws Exception {
        for(int i = 0; i < 10; i++){
            System.out.println(RandomStringUtils.randomAlphabetic(5));
        }
    }
}
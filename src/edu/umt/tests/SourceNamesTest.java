package edu.umt.tests;

import edu.umt.jsf.beans.SourcesBackingBean;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tb189431e on 7/30/15.
 */
public class SourceNamesTest {

    @Test
    public void testGetSources(){
        SourcesBackingBean sbb = new SourcesBackingBean();
        Assert.assertTrue(sbb.getSources().size() > 0);
    }
}

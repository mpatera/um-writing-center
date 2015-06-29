package edu.umt.jsf.beans;

import org.apache.log4j.Logger;

import javax.faces.context.FacesContext;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tb189431e on 5/8/14.
 */
public class BaseBackingBean {
    private Logger log = Logger.getLogger(BaseBackingBean.class);
    Properties properties;

    public BaseBackingBean(){
        try{
            InputStream input = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("queries.properties");
            properties = new Properties();
            properties.load(input);
        }catch(Exception e){
            log.error(e);
        }
    }
}

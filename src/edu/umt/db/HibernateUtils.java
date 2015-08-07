package edu.umt.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tb189431e on 6/11/15.
 * This class is written specifically for Hibernate 4.2.x
 */
public final class HibernateUtils {
    private static final Logger log = LoggerFactory.getLogger(HibernateUtils.class);
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    private HibernateUtils(){}

    private static SessionFactory createSessionFactory(String database){
        try{
            if(database.equals("writingcenter")) {
                final Configuration configuration = new Configuration();
                configuration.configure();
                serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } else if(database.equals("banner")){
                final Configuration configuration = new Configuration();
                configuration.configure();
                serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            }
        } catch (Exception ex){
            log.error("Initial SessionsFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(String database) {
        return createSessionFactory(database);
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
